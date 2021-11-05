package in.apssdc.util;

public class StringUtil {

	public static String tocommaseperatedString(Object[] items)
	{
		StringBuilder sb = new StringBuilder();
		for(Object item:items)
		{
			sb.append(item).append(","); // 1,2,3,4,5
		}
		if(sb.length()>0)
		{
			sb.deleteCharAt(sb.length()-1);
		}
		return sb.toString();
	}
}
