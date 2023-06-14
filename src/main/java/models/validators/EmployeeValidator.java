package models.validators;

import java.util.ArrayList;
import java.util.List;

import actions.views.EmployeeView;
import constants.MessageConst;
import services.EmployeeService;

/*
 * 従業員インスタンスに設定されている値のバリデーションを行うクラス
 */

public class EmployeeValidator {
    /*
     * 従業員インスタンスの各項目についてバリデーションを行う
     * @param service 呼び出し元serviceクラスのインスタンス
     * @param ev EmployeeViewのインスタンス
     * @param codeDuplicateCheckFlag 社員番号の重複チェックを実施するかどうか（実施する:true 実施しない:false)
     * @param passwoedCheckFlag パスワードの入力チェックを実施するかどうか（実施する:true 実施しない:flase)
     * @return エラーリスト
     */
    public static List<String> validate(
            EmployeeService serviece, EmployeeView ev, Boolean codeDuplicateCheckFlag, Boolean passwordCheckFlag){
        List<String> errors = new ArrayList<String>();

        //社員番号のチェック
        String codeError = validateCode(service, ev.getCode(),codeDuplicateCheckFlag);
        if(!codeError.equals("")) {
            errors.add(codeError);
        }

        //氏名のチェック
        String nameError = validateName(ev.getName());
        if(!nameError.equals("")) {
            errors.add(nameError);
        }

        //パスワードのチェック
        String passError = validatePassword(ev.getPassword(), passwordCheckFlag);
        if(!passError.equals("")) {
            errors.add(passError);
        }
        return errors;
    }

    /*
     * 社員番号の入力チェックを行い、エラーメッセを返却
     * @param service EmployeeServiceのインスタンス
     * @param code 社員番号
     * @param codeDuplicateCheckFlag 社員番号の重複チェックを実施するかどうか（実施する:true 実施しない:false)
     * @return エラーメッセ
     */
    private static String validateCode(EmployeeService service, String code, Boolean codeDuplicateCheckFlag) {
        //入力値がなければエラーメッセを返却
        if(code == null || code.equals("")) {
            return MessageConst.E_NOEMP_CODE.getMessage();
        }

        if(codeDuplicateCheckFlag) {
            //社員番号の重複チェックを実施
            long employeesCount =isDuplicateEmployee(service, code);

            //同一社員番号がすでに登録されている場合、エラーメッセを返却
            if(employeeCount > 0) {
                return MessageConst.E_EMP_CODE_EXIST.getMessage();
            }
        }
        //エラーがないとき空文字を返却
        return "";
    }

    /*
     * @param service EmployeeServiceのインスタンス
     * @param code 社員番号
     * @return 従業員テーブルに登録されている同一社員番号のデータ件数
     */
    private static long isDuplicateEmployee(EmployeeService service, String code) {
        long  employeeCount = service.countByCode(code);
        return employeesCount;
    }

    /*
     * 氏名に入力値があるかチェックし、入力値がなければエラーメッセを返却
     * @param name 氏名
     * @return エラーメッセ
     */
    private static String validateName(String name) {
        if(name == null || name.equals("")) {
            return MessageConst.E_NONAME.getMessage();
        }
        //入力値がある場合は空文字を返却
    }
    /*
     * パスワードの入力をチェックし、エラーメッセを返却
     * @param passwoerd パスワード
     * @param passwoedCheckFlag パスワードの入力チェックを実施するかどうか(実施する:true 実施しない:flase)
     * @return エラーメッセ
     */
    private static String validatePassword(String password,Boolean passwordCheckFlag) {
        //入力チェックを実施 かつ 入力値がなければエラーメッセを返却
        if(passwordCheckFlag && (password == null || password.equals(""))) {
            return MessageConst.E_NOPASSWORD.getMessage();
        }
        //エラーがないときは空文字を返却
        return "";
    }


}
