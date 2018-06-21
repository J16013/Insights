package insights;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibm.watson.developer_cloud.discovery.v1.model.CreateCollectionOptions.Language;
import com.ibm.watson.developer_cloud.personality_insights.v3.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.Profile;
import com.ibm.watson.developer_cloud.personality_insights.v3.model.ProfileOptions;

public class Insights_lib {

	private PersonalityInsights service;
	private List<Double> Personality = new ArrayList<Double>();
	private List<List<Double>> Attribute = new ArrayList<List<Double>>();

	public Insights_lib() {
		service = new PersonalityInsights("2016-10-19");
		service.setUsernameAndPassword("88a48ecb-09c8-4df7-adbd-430c48364532", "5stD20q0pB18");
	}

	public void getProfile(String text) {
		ProfileOptions options = new ProfileOptions.Builder()
				.contentLanguage(Language.JA)	//日本語入力
				.acceptLanguage(Language.JA)	//日本語出力
				.text(text)
				.build();

		Profile profile = service.profile(options).execute();

		System.out.println(profile);
		System.out.println();
		this.getJson(profile.toString(),text);
	}

	public void getJson(String json,String text) {

		JsonNode node = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			node = mapper.readTree(json.toString());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		//大きいカテゴリーだけ取得
		for(JsonNode jn : node.get("personality")){
			Personality.add(jn.get("percentile").asDouble());
		}

		//小さいカテゴリだけ取得
		for(JsonNode jn : node.get("personality")){
			//適当なListを作って入れる
			List<Double> test = new ArrayList<Double>();
			for(JsonNode jnn : jn.get("children")){
				test.add(jnn.get("percentile").asDouble());
			}
			Attribute.add(test);
		}

		MySQL mysql = new MySQL();
		mysql.insertScreens(Personality, Attribute, text);
	}
	public void showClassification(){
		System.out.println("Openness(知的好奇心)属性");
		System.out.println("Adventurousness(大胆性), Artistic interests(芸術的関心度), Emotionality(情動性), Imagination(想像力), Intellect(思考力), Authority-challenging(現状打破)");
		System.out.println("Conscientiousness(誠実性)属性");
		System.out.println("Achievement striving(達成努力), Cautiousness(注意深さ), Dutifulness(忠実さ), Orderliness(秩序性), Self-discipline(自制力), Self-efficacy(自己効力感)");
		System.out.println("Extraversion(外向性)属性");
		System.out.println("Activity level(活発度), Assertiveness(自己主張), Cheerfulness(明朗性), Excitement-seeking(刺激希求性), Outgoing(友好性), Gregariousness(社交性)");
		System.out.println("Agreeableness(協調性)属性");
		System.out.println("Altruism(利他主義), Cooperation(協働性), Modesty(謙虚さ), Uncompromising(強硬さ), Sympathy(共感度), Trust(信用度)");
		System.out.println("Neuroticism(感情起伏)属性");
		System.out.println("Fiery(激情的), Prone to worry(心配性), Melancholy(悲観的), Immoderation(利己的), Self-consciousness(自意識過剰), Susceptible to stress(低ストレス耐性)");

	}

}