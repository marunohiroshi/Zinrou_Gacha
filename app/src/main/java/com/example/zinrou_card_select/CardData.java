package com.example.zinrou_card_select;

import java.util.ArrayList;
import java.util.List;

public enum CardData {
    simin("市民", "特殊能力を持たない。" + "\n" + "人狼が全滅することが勝利条件。", R.drawable.simin, "市民"),
    uranaishi("占い師", "毎晩1人を占うことができる。" + "\n" + "その人が「人狼」か「人狼ではない」かが分かる。", R.drawable.uranaishi, "市民"),
    reinousya("霊能者", "毎晩処刑された人が人狼かそうでないかが分かる。", R.drawable.reinousya, "市民"),
    jadgement_mazyo("魔女", "夜に能力を２度まで行使できる。" + "\n" + "能力は毒薬を使った誰かの毒殺か、蘇生薬を使ったその日の処刑者の蘇生。" + "\n" + "ただし蘇生は１度しか使えない", R.drawable.jadgement_mazyo, "市民"),
    kaitou("怪盗", "初日の朝に誰か1人から役職を盗むことができる。" + "\n" + "選んだ役職固有の能力は次の日の夜から使用可能。" + "\n" + "盗まれた人は初日の夜は役職を盗まれたことに気付かず２日目からただの市民となる。" + "\n" + "人狼を知る役職が盗まれた場合には死亡する。", R.drawable.kaitou, "市民"),
    akazukin("赤ずきん", "人狼に襲撃された場合に仮死状態になる。" + "\n" + "次の日以降に人狼が死亡すると人狼の腹の中から復活する。", R.drawable.akazukin, "市民"),
    annsatsusya("暗殺者", "夜の間に一度だけ誰かを暗殺できる。" + "\n" + "狩人の護衛や罠師の罠があっても暗殺可能。", R.drawable.annsatsusya, "市民"),
    bannkenn("番犬", "初日の夜に「飼い主」を選ぶ。" + "\n" + "番犬が生きている間、飼い主は人狼の襲撃から守られる。" + "\n" + "２日目以降の行動で、飼い主を襲撃することができるようになる。" + "\n" + "占い結果は「人狼」と判定される。", R.drawable.bannkenn, "市民"),
    byounin("病人", "人狼に襲撃された場合、人狼は翌日に襲撃することができなくなる。", R.drawable.byounin, "市民"),
    deshi("占い師の弟子", "占い師が死んだ場合、その後自分が占い師の能力を手に入れる。", R.drawable.deshi, "市民"),
    detective("名探偵", "毎晩襲撃されて死んだ人の役職を知ることができる。" + "\n" + "サイコ占いや毒殺で死んだ人の役職も分かる。", R.drawable.detective, "市民"),
    dokusaisya("独裁者", "「独裁者CO」をすることで一度だけ昼の時間を終わらせその日の処刑者を決めることができる。", R.drawable.dokusaisya, "市民"),
    dorei("奴隷", "貴族が誰かを知っている。" + "\n" + "市民陣営勝利の時に貴族が死んでいないと勝利にならない。" + "\n" + "自分は死んでいてもよい。", R.drawable.dorei, "市民"),
    driver("新聞配達", "新聞配達が生存していれば、無残に死んだ人の死因の情報を朝に届ける。" + "\n" + "配達回数は屋敷の設定で変更可能。", R.drawable.driver, "市民"),
    gambler("ギャンブラー", "投票の際に投票せずに自分の票を貯めることができる。" + "\n" + "貯めた票はどこかでまとめて使うことができる。", R.drawable.gambler, "市民"),
    hutago("双子", "双子は互いを認識することができる、片方が死んだときに後追いするかは屋敷の設定による。", R.drawable.hutago, "市民"),
    ikiryou("生霊", "初日の夜に誰かを選んでとり憑く。" + "\n" + "その人が死んだ場合、役職をコピーし能力・勝利条件なども引き継ぐ。", R.drawable.ikiryou, "市民"),
    isya("医者", "夜の間に注射をすることで人狼の襲撃から守ることができる。" + "\n" + "自分に注射も可能。" + "\n" + "ただし２日連続で注射した場合その人は死亡する", R.drawable.isya, "市民"),
    kariudo("狩人", "毎晩1人を護衛する。" + "\n" + "その人が人狼に襲撃された場合、犠牲者が発生しない。", R.drawable.kariudo, "市民"),
    kennzya("賢者", "毎晩１人を占うことができる。" + "\n" + "その人の役職が分かる。", R.drawable.kennzya, "市民"),
    killer("人狼キラー", "人狼に襲撃されると人狼の中からランダムで道連れにする。" + "\n" + "処刑では道連れは発生しない。", R.drawable.killer, "市民"),
    kizoku("貴族", "必ず「奴隷」とセットで入る。" + "\n" + "人狼に襲撃された時に奴隷が生きていれば奴隷が代わりに死亡する。", R.drawable.kizoku, "市民"),
    miko("巫女", "夜に一度だけ聖なる護りを使って自分を守ることができる。" + "\n" + "聖なる護りはその日の夜から次の日の処刑の後まで有効となる。" + "\n" + "突然死、後追いの死亡は防げない。", R.drawable.miko, "市民"),
    nekomata("猫又", "人狼に襲撃された時、人狼のなかから1人ランダムで道連れにする。" + "\n" + "処刑された時、生存者の中からランダムで1人道連れにする。", R.drawable.nekomata, "市民"),
    niseuranai("偽占い師", "毎晩誰かを占うことができるが占い結果は「人狼ではない」としか出ない。" + "\n" + "自分は「占い師」と表示され、偽占い師であることは分からない。", R.drawable.niseuranai, "市民"),
    ookamituki("狼憑き", "能力を持たない市民陣営だが、占い結果は「人狼」と判定される。", R.drawable.ookamituki, "市民"),
    pannya("パン屋", "パン屋が生きているかはその日の最初に皆に分かる。", R.drawable.pannya, "市民"),
    princess("プリンセス", "女王が死んで自分が生存していれば、女王の能力を引き継ぐ。" + "\n" + "女王は誰がプリンセスかを知っているが、プリンセス自身や他の人は誰がプリンセスかは分からない。" + "\n" + "必ず女王とセットで入る。", R.drawable.princess, "市民"),
    noroware("呪われし者", "自分が呪われしものであることは分からない。" + "\n" + "人狼に襲撃されると翌日から人狼になる。", R.drawable.noroware, "市民"),
    seisyoku("聖職者", "自分以外の誰かを聖なる護りで守る。" + "\n" + "その人は一度だけ死から守られる。", R.drawable.seisyoku, "市民"),
    sityou("市長", "市長の投票は２票分の効果を持つ。", R.drawable.sityou, "市民"),
    toubousya("逃亡者", "毎晩１人を選んでその人のところに逃亡する。" + "\n" + "逃亡先が人狼であったり、襲撃された場合は死亡する。" + "\n" + "逃亡していて自分が襲撃されても死亡しない。" + "\n" + "逃亡しないと死亡するかどうかは屋敷の設定による。", R.drawable.toubousya, "市民"),
    tyourou("長老", "人狼に襲撃されても1度目は死亡しない。" + "\n" + "長老が死ぬと市民側は全員能力が使えなくなる。", R.drawable.tyourou, "市民"),
    wanashi("罠師", "毎晩１人のところに罠を仕掛ける。" + "\n" + "人狼がその人を襲撃した場合その人は死なず人狼が死亡する。", R.drawable.wanashi, "市民"),
    waraningyou("わら人形", "自分が襲撃あるいは処刑された場合、誰か1人を選んで道連れにする。", R.drawable.waraningyou, "市民"),
    zyoou("女王", "自身が死んだ場合、市民陣営の負けとなる。" + "\n" + "市民陣営からは誰が女王であるか分かる。", R.drawable.zyoou, "市民"),
    zyouzetu_guard("饒舌な狩人", "お題を言わないと死んでしまう狩人。" + "\n" + "饒舌な人狼の狩人バージョン。", R.drawable.zyouzetu_guard, "市民"),
    jinro("人狼", "毎晩誰かを選んで襲撃することができる。" + "\n" + "市民の数を人狼の数以下にすることが勝利条件。", R.drawable.jinro, "人狼"),
    kyouzin("狂人", "勝利条件は人狼と同じ。", R.drawable.kyouzin, "人狼"),
    saiko("サイコ", "夜の行動でサイコに関わったプレイヤーをすべて殺してしまう。", R.drawable.saiko, "人狼"),
    gouyokunajinrou("強欲な人狼", "一晩に２人を襲撃することができる。" + "\n" + "この能力は1度だけ使用可能。", R.drawable.gouyokunajinrou, "人狼"),
    hangyaku_kyouzin("反逆の狂人", "自分が生きていると、独裁者COを無効にして独裁者本人を処刑することができる。" + "\n" + "その他は狂人と同じ。", R.drawable.hangyaku_kyouzin, "人狼"),
    itizu_wolf("一途な人狼", "一度だけ命がけの襲撃を行うことができる。" + "\n" + "その際は通常殺せない相手（長老、妖狐、護衛対象など）も襲撃することができる。" + "\n" + "通常殺せない相手を襲撃した場合、自分も死んでしまう。", R.drawable.itizu_wolf, "人狼"),
    jyouzetunajinrou("饒舌な人狼", "基本的な能力は人狼と同じだが、" + "\n" + "昼の最初に指定されるワードをその日の昼の時間に言わないと死亡してしまう。", R.drawable.jyouzetunajinrou, "人狼"),
    kennrou("賢狼", "基本的な能力は人狼と同じ。" + "\n" + "襲撃した相手の役職を知ることができる。", R.drawable.kennrou, "人狼"),
    kuroneko("黒猫", "処刑された場合、人狼以外から1人をランダムで道連れにする。", R.drawable.kuroneko, "人狼"),
    kyousin("狂信者", "人狼が誰であるかが分かる。", R.drawable.kyousin, "人狼"),
    lonely_wolf("一匹狼", "人狼チャットに参加できない狼。" + "\n" + "他の人狼やささやく狂人からも認識されない。" + "\n" + "自分は他の仲間は分かる。", R.drawable.lonely_wolf, "人狼"),
    nouarujinrou("能ある人狼", "人狼だが、「襲撃しない」という選択肢を取れる。", R.drawable.nouarujinrou, "人狼"),
    ookamisyounen("狼少年", "毎晩1人を人狼に仕立て上げることができる。" + "\n" + "仕立てられた人は翌日占われると「人狼」と判定される。", R.drawable.ookamisyounen, "人狼"),
    sasaki("ささやく狂人", "人狼が誰かを知っていて、人狼とコミュニケーションを取ることができる。", R.drawable.sasaki, "人狼"),
    tairou("大狼", "基本的な能力は人狼と同じだが、" + "\n" + "占い師に占われると「人狼ではない」と判定される。" + "\n" + "霊能者には「大狼」と判定される。", R.drawable.tairou, "人狼"),
    yomigaerujinrou("蘇る人狼", "1度だけ夜の行動で「仮死状態になる」を取ることができる。" + "\n" + "その場合自分が襲撃されて死亡となり、２日後の朝に復活する。", R.drawable.yomigaerujinrou, "人狼"),
    youzyutu("妖術師", "毎晩1人を占うことができる。" + "\n" + "占った相手の役職が分かる。", R.drawable.youzyutu, "人狼"),
    fox("妖狐", "市民陣営か人狼陣営が勝利した時に生存していると勝利した陣営に代わり勝利となる。" + "\n" + "人狼に襲撃されても死亡しないが、占われると呪殺されてしまう。", R.drawable.fox, "妖狐"),
    haishin("背信者", "妖狐陣営と勝利条件は同じ。" + "\n" + "妖狐や子狐が分かり、妖狐や子狐からも認識される。" + "\n" + "妖狐と子狐が全滅すると自分も後追いする", R.drawable.haishin, "妖狐"),
    haitoku("背徳者", "勝利条件は妖狐と同じ。" + "\n" + "誰が妖狐・子狐かを知っている。" + "\n" + "特殊能力を持たない。", R.drawable.haitoku, "妖狐"),
    kogitune("小狐", "勝利条件は妖狐と同じ。誰が妖狐かを知っている。" + "\n" + "妖狐とは違い占われても死亡しないが、人狼に襲撃されると死亡してしまう。" + "\n" + "毎晩誰かを占うことができ、５０％の確率でその人が人狼かそうでないかが分かる", R.drawable.kogitune, "妖狐"),
    amanozyaku("天邪鬼", "市民陣営以外が勝利することが勝利条件。" + "\n" + "自分の生死は問わない。", R.drawable.amanozyaku, "その他"),
    avenger("復讐者", "１度だけ夜に１人を選んで仇敵にする。" + "\n" + "ゲーム終了時に自分が生存していて仇敵が死亡していれば勝利となる。" + "\n" + "最後まで仇敵を選ばないと敗北する。", R.drawable.avenger, "その他"),
    buta("ぶた男", "自分が人狼に襲撃されると勝利陣営に追加で勝利となる。", R.drawable.buta, "その他"),
    koumori("コウモリ男", "自分が最後まで生き残ると勝利陣営に追加で勝利となる。", R.drawable.koumori, "その他"),
    purelove("純愛者", "初日夜に愛する人を選ぶ。" + "\n" + "愛する人が勝利することが勝利条件となる。" + "\n" + "愛する人が処刑以外で死亡する場合、自分が身代わりとなり死亡する。", R.drawable.purelove, "その他"),
    teruteru("てるてる坊主", "自分が処刑されると勝利陣営に追加で勝利となる。", R.drawable.teruteru, "その他"),
    yakubyou("疫病神", "通常の役職に追加されるが自身が疫病神とは気づかない。" + "\n" + "自分が投票した票がカウントされなくなる。" + "\n" + "市長やギャンブラーなど複数投票ができる場合は、１票だけ減る。", R.drawable.yakubyou, "その他"),
    yopparai("酔っ払い", "通常の役職に追加されて酔っ払いとなる。" + "\n" + "酔っ払いは最初「市民」と表示される。" + "\n" + "酔いが覚めると自分の役職を認識し能力が使えるようになる。" + "\n" + "酔っ払いのターンは設定可能", R.drawable.yopparai, "その他"),
    zyunnkyou("殉教者", "自分が死亡すると勝利陣営に加え追加で勝利となる。", R.drawable.zyunnkyou, "その他"),
    koibito("恋人", "通常の役職に追加されて恋人となる（人狼かつ恋人などの兼任）" + "\n" + "誰が恋人かを互いに知っている。" + "\n" + "市民陣営、人狼陣営のどちらかが勝利した時に恋人が生存していればその陣営に変わり恋人が勝利となる。" + "\n" + "組んでいる恋人が死亡すると自分も後追いで死亡する。", R.drawable.koibito, "恋人"),
    qupid("キューピッド", "初日の夜に２人の恋人を選ぶ（自分を選択も可）。" + "\n" + "最後まで恋人の２人が生存していると勝利となる。" + "\n" + "恋人でなければ自分の生死は問わない。", R.drawable.qupid, "恋人"),
    evilgirl("悪女", "初日の夜に本命と手玉を選ぶ。" + "\n" + "本命と自分が恋人となり最後まで生存すれば勝利となる。" + "\n" + "手玉は自分が悪女と恋人であると表示される。" + "\n" + "手玉が死んでも後追いはしない。", R.drawable.evilgirl, "恋人"),
    santa("サンタ", "毎晩誰か１人にプレゼントを配る。" + "\n" + "自分以外の生存者全員にプレゼントを配り終えるとサンタは屋敷から退出し、" + "\n" + "勝利陣営に追加で勝利となる。", R.drawable.santa, "サンタ"),
    tonakai("赤鼻のトナカイ", "サンタが誰か分かるが、サンタからは認識されない。" + "\n" + "サンタが襲撃されると身代わりで死亡し、サンタが死亡すると後追いで死亡する。" + "\n" + "サンタ勝利時には、自分もサンタとともに退出する。", R.drawable.tonakai, "サンタ"),
    zombie("ゾンビ", "毎晩誰か1人を感染させてゾンビにする。" + "\n" + "自分が生存していてかつ生存者全員が感染者になったらその瞬間ゾンビの勝利となる。" + "\n" + "（感染者は勝利ではない）。", R.drawable.zombie, "ゾンビ"),
    zombie_mania("ゾンビマニア", "ゾンビ陣営が勝利すると自分も勝利する。" + "\n" + "ゾンビが誰か分かるが、ゾンビからは認識されない。" + "\n" + "ゾンビ死亡時、自分が生きていれば新たにゾンビとなる。", R.drawable.zombie_mania, "ゾンビ");

    private final String name;
    private final String effect;
    private final int drawable;
    private final String camp;
    private static final int GACHA_CARD_DATA_QUANTITY = 74;

    CardData(String name, String effect, int drawable, String camp) {
        this.name = name;
        this.effect = effect;
        this.drawable = drawable;
        this.camp = camp;
    }

    public String getName() {
        return name;
    }

    public String getEffect() {
        return effect;
    }

    public int getDrawable() {
        return drawable;
    }

    public String getCamp() {
        return camp;
    }

    public static CardData[] getCamp(CardData[] cardDataSet, String camp) {
        List cardData = new ArrayList();
        for (int i = 0; i < cardDataSet.length; i++) {
            if (cardDataSet[i].getCamp().equals(camp)) {
                cardData.add(CardData.values()[i]);
            }
        }
        return (CardData[]) cardData.toArray(new CardData[cardData.size()]);
    }
}
