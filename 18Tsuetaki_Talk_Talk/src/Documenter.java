/**
 * This class is so i can learn about documenting
 * @author ATsuetaki
 * @version Wednesday 09/09/16
 */
public class Documenter {
	/**
	 * @return
	 */
	public static String getHello()	{
		return "hello";
	}
	/*
	 * simply prints hello to the terminal
	 */
	public static void sayHello()	{
		System.out.println("hello");
	}
	
	public static int getNum()	{
		return (int)(Math.random()*101);
	}
	/**
	 * takes in number and returnes the number cubed
	 * @param num
	 * @return
	 */
	public static void getFunnyNum(int num)	{
		return Math.pow(num, 3);
	}
	/**
	 * ,aom ,ethod for class documentor.the entry point
	 * @param args
	 */
	public static void main(String[] args)	{
		System.out.println(getHello());
		sayHello();	}
}
