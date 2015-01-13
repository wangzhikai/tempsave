package tea.looca;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class TODODiffDaysOfDate {
	public static void main(String [] argv) {
		//NIL Calendar c1 = new Calendar();
		System.out.println(Locale.getDefault());// eg. en_US
		Calendar now = Calendar.getInstance();
		System.out.println(now.toString());
		//java.util.GregorianCalendar[time=1420831228223,areFieldsSet=true,areAllFieldsSet=true,lenient=true,zone=sun.util.calendar.ZoneInfo[id="America/Los_Angeles",offset=-28800000,dstSavings=3600000,useDaylight=true,transitions=185,lastRule=java.util.SimpleTimeZone[id=America/Los_Angeles,offset=-28800000,dstSavings=3600000,useDaylight=true,startYear=0,startMode=3,startMonth=2,startDay=8,startDayOfWeek=1,startTime=7200000,startTimeMode=0,endMode=3,endMonth=10,endDay=1,endDayOfWeek=1,endTime=7200000,endTimeMode=0]],firstDayOfWeek=1,minimalDaysInFirstWeek=1,ERA=1,YEAR=2015,MONTH=0,WEEK_OF_YEAR=2,WEEK_OF_MONTH=2,DAY_OF_MONTH=9,DAY_OF_YEAR=9,DAY_OF_WEEK=6,DAY_OF_WEEK_IN_MONTH=2,AM_PM=0,HOUR=11,HOUR_OF_DAY=11,MINUTE=20,SECOND=28,MILLISECOND=223,ZONE_OFFSET=-28800000,DST_OFFSET=0]
		System.out.println(new SimpleDateFormat("YYYYMMDD").format(now.getTime()));
		String[] formats = {
				"yyyy.MM.dd G 'at' HH:mm:ss z",
				"EEE, MMM d, ''yy",
				"h:mm a",
				"hh 'o''clock' a, zzzz",
				"K:mm a, z",
				"yyyyy.MMMMM.dd GGG hh:mm aaa",
				"EEE, d MMM yyyy HH:mm:ss Z",
				"yyMMddHHmmssZ",
				"yyyy-MM-dd'T'HH:mm:ss.SSSZ",
				"yyyy-MM-dd'T'HH:mm:ss.SSSXXX",
				"YYYY-'W'ww-u"
				//""//get empty line
		};
		
		// WARN: always remember a date string as an input without time zone is NOTHING but a bug.
//		for (String f: formats) {
//			System.out.println(new SimpleDateFormat(f).format(now.getTime()));
//		}
		String [] dateInputs = { 
				"20150109",
                "2015.01.09 AD at 11:38:54 PST",
                "Fri, Jan 9, '15",
                "11:38 AM",
                "11 o'clock AM, Pacific Standard Time",
                "11:38 AM, PST",
                "02015.January.09 AD 11:38 AM",
                "Fri, 9 Jan 2015 11:38:54 -0800",
                "150109113854-0800",
                "2015-01-09T11:38:54.678-0800",
                "2015-01-09T11:38:54.678-08:00",
                "2015-W02-5"
		};
		
		for (int i= 0; i< dateInputs.length; i++) {
			try {
				System.out.println(new SimpleDateFormat(formats[i]).parse(dateInputs[i]));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		/*
java.text.ParseException: Unparseable date: "20150109"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "2015.01.09 AD at 11:38:54 PST"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "Fri, Jan 9, '15"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "11:38 AM"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "11 o'clock AM, Pacific Standard Time"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "11:38 AM, PST"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "02015.January.09 AD 11:38 AM"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "Fri, 9 Jan 2015 11:38:54 -0800"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "150109113854-0800"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "2015-01-09T11:38:54.678-0800"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
java.text.ParseException: Unparseable date: "2015-01-09T11:38:54.678-08:00"
	at java.text.DateFormat.parse(DateFormat.java:357)
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 11
	at tea.looca.TODODiffDaysOfDate.main(TODODiffDaysOfDate.java:52)
		 */

	}

}
