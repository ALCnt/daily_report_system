package actions;

import java.io.IOException;

import javax.servlet.ServletException;

import constants.AttributeConst;
import constants.ForwardConst;

/*
 * トップページに関する処理を行うページ
 */

public class TopAction extends ActionBase {

    /*
     * indexメソッド実行
     */
    @Override
    public void process() throws ServletException, IOException{
        //メソッド実行
        invoke();
    }
    /*
     * 一覧画面を表示
     */
    public void index() throws ServletException, IOException{
        //セッションにフラッシュメッセが設定されている場合、リクエストスコープに移し替え、セッションから削除
        String flush = getSessionScope(AttributeConst.FLUSH);
        if(flush != null) {
            putRequestScope(AttributeConst.FLUSH, flush);
            removeSessionScope(AttributeConst.FLUSH);
        }

        //一覧画面を表示
        forward(ForwardConst.FW_TOP_INDEX);
    }


}
