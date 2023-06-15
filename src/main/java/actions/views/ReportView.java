package actions.views;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 * 日報情報について画面の入力値・出力値を扱うViewモデル
 */

@Getter //すべてのクラスフィールドについてgetterの自動生成 lombok
@Setter //すべてのクラスフィールドについてsetterの自動生成 lombok
@NoArgsConstructor //引数なしコンストラクタの自動生成
@AllArgsConstructor //すべてのクラスフィールドを引数に持つ引数ありコンストラクタを自動生成 lombok
public class ReportView {
    /*
     * id
     */
    private Integer id;

    /*
     * 日報を登録した従業員
     */
    private EmployeeView employee;

    /*
     * いつの日報か
     *
     */
    private LocalDate reportDate;

    /*
     * 日報タイトル
     */
    private String title;

    /*
    日報内容
    */
    private String content;

    /*
     * 登録日時
     *
     */
    private LocalDateTime createdAt;

    /*
     * 更新日時
     */
    private LocalDateTime updatedAt;

}
