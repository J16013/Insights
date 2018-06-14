package insights;

public class Insights_main {

	public static void main(String[] args) {

		String text = "つれづれなるままに、日くらし硯にむかひて、心にうつりゆくよしなし事を、"
				+ "そこはかとなく書きつくれば、あやしうこそものぐるほしけれ。 "
		        + "いでや、この世に生まれては、願はしかるべき事こそ多か（ん）めれ。"
		        + "御門（みかど）の御位（おおんくらい）はいともかしこし、"
		        + "竹の園生（そのふ）の末葉まで、人間の種ならぬぞやんごとなき。"
		        + "一の人の御有様はさらなり、ただ人（うど）も、舎人など賜はるきはは、ゆゆしと見ゆ。"
		        + "その子、孫（むまご）までは、はふれにたれど、なほなまめかし。"
		        + "それより下（しも）つかたは、ほどにつけつつ、時にあひ、したり顔なるも、"
		        + "みづからはいみじと思ふらめど、いとくちをし。"
		        + "いにしへのひじりの御世の政をもわすれ、民の愁（うれへ)、国のそこなはるるをも知らず、"
		        + "よろづにきよらをつくしていみじと思ひ、所せきさましたる人こそ、うたて、思ふところなく見ゆれ。"
		        + "「衣冠より馬・車にいたるまで、有るにしたがひて用ゐよ。美麗をもとむる事なかれ」とぞ、九条殿の遺誡にも侍る。"
		        + "順徳院の、禁中の事ども書かせ給へるにも、「おほやけの奉り物は、おろそかなるをもてよしとす」とこそ侍れ。"
		        + "よろづにいみじくとも、色好まざらん男（おのこ）は、いとさうざうしく、玉の巵（さかづき）の当（そこ）なき心地ぞすべき。"
		        + "露霜にしほたれて、所定めずまどひ歩き、親のいさめ、世のそしりをつつむに心の暇なく、"
		        + "あふさきるさに思ひ乱れ、さるは独り寝がちに、まどろむ夜なきこそをかしけれ。"
		        + "さりとて、ひたすらたはれたる方にはあらで、女にたやすからず思はれんこそ、あらまほしかるべきわざなれ。"
		        + "後の世の事、心にわすれず、仏の道うとからぬ、こころにくし。"
		        + "不幸に愁にしづめる人の、頭おろしなど、ふつつかに思ひとりたるにはあらで、"
		        + "有るかなきかに門さしこめて、待つこともなく明し暮したる、さるかたにあらまほし。"
		        + "顕基中納言の言ひけん、配所の月、罪なくて見ん事、さも覚えぬべし。"
				;

		Insights_lib insights_lib = new Insights_lib();
		insights_lib.getProfile(text);
	  }

}