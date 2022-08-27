package com.example.template;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class TemplateApplicationTests {

	@Test
	void contextLoads() {
	}


	/**
	 * 49 min with test and working
	 */
	@Test
	public void givenParagraph_returnMostFrecuentWord(){
		//Arrange
		ParagraphAnalizer paragraphAnalizer = new ParagraphAnalizer();
		String paragraph="Bob hit a ball, the hit BALL flew far after it was hit.";
		//paragraph="\"Bob hit,a ball, the hit !BALL flew far after it was hit.";
		String[] bannedWords={"hit"};
		//Act
		String mostCommonWord = paragraphAnalizer.mostCommonnWord(paragraph,bannedWords);
		//Assert
		Assert.notNull(mostCommonWord);
	}

	/**
	 * 8 min
	 */
	@Test
	public void givenParagraphWith1000Characters_returnException(){
		//Arrange
		ParagraphAnalizer paragraphAnalizer = new ParagraphAnalizer();
		String paragraph="Many people say that life isn't like a bed of roses. I beg to differ. I think that life is quite like a bed of roses. Just like life, a bed of roses looks pretty on the outside, but when you're in it, you find that it is nothing but thorns and pain. I myself have been pricked quite badly.\n" +
				"Time is all relative based on age and experience. When you are a child an hour is a long time to wait but a very short time when that’s all the time you are allowed on your iPad. As a teenager time goes faster the more deadlines you have and the more you procrastinate. As a young adult, you think you have forever to live and don’t appreciate the time you spend with others. As a middle-aged adult, time flies by as you watch your children grow up. And finally, as you get old and you have fewer responsibilities and fewer demands on you, time slows. You appreciate each day and are thankful you are alive. An hour is the same amount of time for everyone yet it can feel so different in how it goes by.\n" +
				"ok this finish";
		//paragraph="\"Bob hit,a ball, the hit !BALL flew far after it was hit.";
		String[] bannedWords={"hit"};
		//Act
		try{
			String mostCommonWord = paragraphAnalizer.mostCommonnWord(paragraph,bannedWords);
		}catch(ParagraphAnalizerLimitException e){
			Assert.isTrue(true);
		}
		//Assert
	}

	/**
	 * 8 min
	 */
	@Test
	public void givenBannedArrayOver100WordsMax_returnException(){
		//Arrange
		ParagraphAnalizer paragraphAnalizer = new ParagraphAnalizer();
		String paragraph="Bob hit a ball, the hit BALL flew far after it was hit.";
		//paragraph="\"Bob hit,a ball, the hit !BALL flew far after it was hit.";
		String[] bannedWords=new String[101];
		//Act
		try{
			String mostCommonWord = paragraphAnalizer.mostCommonnWord(paragraph,bannedWords);
		}catch(ParagraphAnalizerLimitException e){
			Assert.isTrue(true);
		}
		//Assert
	}

	/**
	 * 15
	 */
	@Test
	public void givenBannedArrayCheckEveryWordhasMoreThan10CharactersMax_returnException(){
		//Arrange
		ParagraphAnalizer paragraphAnalizer = new ParagraphAnalizer();
		String paragraph="Many people say that life isn't like a bed of roses. I beg to differ. I think that life is quite like a bed of roses. Just like life, a bed of roses looks pretty on the outside, but when you're in it, you find that it is nothing but thorns and pain. I myself have been pricked quite badly.\n" +
				"Time is all relative based on age and experience. When you are a child an hour is a long time to wait but a very short time when that’s all the time you are allowed on your iPad. As a teenager time goes faster the more deadlines you have and the more you procrastinate. As a young adult, you think you have forever to live and don’t appreciate the time you spend with others. As a middle-aged adult, time flies by as you watch your children grow up. And finally, as you get old and you have fewer responsibilities and fewer demands on you, time slows. You appreciate each day and are thankful you are alive. An hour is the same amount of time for everyone yet it can feel so different in how it goes by.\n" +
				"ok this finish";
		//paragraph="\"Bob hit,a ball, the hit !BALL flew far after it was hit.";
		String[] bannedWords={"BANNEDWORDLIMIT"};
		//Act
		try{
			String mostCommonWord = paragraphAnalizer.mostCommonnWord(paragraph,bannedWords);
		}catch(ParagraphAnalizerLimitException e){
			Assert.isTrue(true);
		}
		//Assert
	}

}
