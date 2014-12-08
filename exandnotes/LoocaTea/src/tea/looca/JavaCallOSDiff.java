package tea.looca;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ProcessBuilder.Redirect;
import java.util.Map;

public class JavaCallOSDiff {

	public static void main(String[] args) throws IOException, InterruptedException {
		/*
		{
			// refer to http://stackoverflow.com/questions/792024/how-to-execute-system-commands-linux-bsd-using-java
			Runtime r = Runtime.getRuntime();
			Process p = r.exec("uname -a");
			p.waitFor();
			BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
	
			while ((line = b.readLine()) != null) {
			  System.out.println(line);
			}
	
			b.close();
		}
		*/
//		{
//			
//		    String myClumsyString1 = "\"Twinkle twinkle little star\\\\n\"\n" +
//		            "\t\t\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
//		            "\t\t\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
//		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
//		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
//		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
//		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
//		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
//		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\";";
//
//		    String myClumsyString2 = "\"Twinkle twinkle little star\\n\"\n" +
//		            "\t\t\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
//		            "\t\t\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
//		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
//		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
//		            "\t\t\t+ \"Twnkle twinkle lttle star\\n\"\n" +
//		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
//		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
//		            "\t\t\t+ \"+ \\\"Twinkle twinkle ltitle star\\n\\\";\";";
//
//			
//			Runtime r = Runtime.getRuntime();
//			//Process p = r.exec("diff  <(echo '"+myClumsyString1+"' ) <(echo \'"+myClumsyString2+"')");
//			//Process p = r.exec("export myClumsyString1=\"1234\"");
////			Process p = r.exec("echo "+myClumsyString1+"");
////			p = r.exec("echo "+myClumsyString1+"");
////			p = r.exec("echo \"$'Hello\nWorld'\" ");
//			// The following line works 
//			Process p = r.exec(new String []{"echo","Hello\nWorld"});
//			p.waitFor();
//			BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			String line = "";
//	
//			while ((line = b.readLine()) != null) {
//			  System.out.println(line);
//			}
//	
//			b.close();
//		}
		{
			
		    String myClumsyString1 = "\"Twinkle twinkle little star\\\\n\"\n" +
		            "\t\t\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
		            "\t\t\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\";";

		    String myClumsyString2 = "\"Twinkle twinkle little star\\n\"\n" +
		            "\t\t\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
		            "\t\t\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
		            "\t\t\t+ \"Twnkle twinkle lttle star\\n\"\n" +
		            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
		            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
		            "\t\t\t+ \"+ \\\"Twinkle twinkle ltitle star\\n\\\";\";";

			
			Runtime r = Runtime.getRuntime();
			//Process p = r.exec("diff  <(echo '"+myClumsyString1+"' ) <(echo \'"+myClumsyString2+"')");
			//Process p = r.exec("export myClumsyString1=\"1234\"");
//			Process p = r.exec("echo "+myClumsyString1+"");
//			p = r.exec("echo "+myClumsyString1+"");
//			p = r.exec("echo \"$'Hello\nWorld'\" ");
			// This one works 
			Process p = r.exec(new String []{"echo",myClumsyString1});
			p.waitFor();
			BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line = "";
			while ((line = b.readLine()) != null) {
			  System.out.println(line);
			}
			b.close();

			// --- cmd
			p = r.exec(new String []{"echo",myClumsyString2});
			p.waitFor();
			b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			line = "";
			while ((line = b.readLine()) != null) {
				System.out.println(line);
			}
			
			// --- cmd
			p = r.exec(new String []{"echo","$(<(echo '"+myClumsyString1+"' ))"});
			p.waitFor();
			b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			line = "";
			while ((line = b.readLine()) != null) {
				System.out.println(line);
			}
			
			// --- cmd
			p = r.exec(new String []{"echo",diff1});
			p.waitFor();
			b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			line = "";
			while ((line = b.readLine()) != null) {
				System.out.println(line);
			}
			
			// --- cmd
			p = r.exec(new String []{"diff",diff1,diff2});
			p.waitFor();
			b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			line = "";
			while ((line = b.readLine()) != null) {
				System.out.println(line);
			}
			
			// --- cmd
			p = r.exec(new String []{"diff",diff1,diff2});
			p.waitFor();
			b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			line = "";
			while ((line = b.readLine()) != null) {
				System.out.println(line);
			}
			
			// --- cmd
			// negative
			p = r.exec(new String []{"diff",diff1,diff2});
			p.waitFor();
			b = new BufferedReader(new InputStreamReader(p.getInputStream()));
			line = "";
			while ((line = b.readLine()) != null) {
				System.out.println(line);
			}
			
			
//			Exception exec not found in mac
//			p = r.exec("exec ls");
//			p.waitFor();
//			b = new BufferedReader(new InputStreamReader(p.getInputStream()));
//			line = "";
//			while ((line = b.readLine()) != null) {
//				System.out.println(line);
//			}
			

		}
		{
			 //ProcessBuilder pb = new ProcessBuilder("diff",  "<(echo '"+diff1+"')","<(echo \'"+diff2+"')");
			ProcessBuilder pb = new ProcessBuilder( "ls");
			 Map<String, String> env = pb.environment();
			 
			 //pb.directory("myDir");
			 Process p = pb.start();
			 BufferedReader b = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line = "";
				while ((line = b.readLine()) != null) {
					System.out.println(line);
				}
//				{SHELL=/bin/bash, TMPDIR=/var/folders/yf/zfn_hj991w909n5_0_rkfn_w0000gp/T/, __CF_USER_TEXT_ENCODING=0x1F6:0x0:0x0, PATH=/usr/bin:/bin:/usr/sbin:/sbin, JAVA_STARTED_ON_FIRST_THREAD_1273=1, XPC_FLAGS=0x0, DISPLAY=/private/tmp/com.apple.launchd.Z9w2zt45qC/org.macosforge.xquartz:0, USER=zwang, JAVA_MAIN_CLASS_2555=tea.looca.JavaCallOSDiff, APP_ICON_1273=../Resources/Eclipse.icns, HOME=/Users/zwang, LOGNAME=zwang, XPC_SERVICE_NAME=org.eclipse.platform.ide.13664, Apple_PubSub_Socket_Render=/private/tmp/com.apple.launchd.X8pgMWT0Mk/Render, SSH_AUTH_SOCK=/private/tmp/com.apple.launchd.4j2tW0V9SG/Listeners}
//				bin
//				src
			
		}
		
		{
			System.out.println(" =============== ");
//			// ProcessBuilder pb = new ProcessBuilder("diff",
//			// "<(echo '"+diff1+"')","<(echo \'"+diff2+"')");
//			ProcessBuilder pb = new ProcessBuilder("ls");
//			Map<String, String> env = pb.environment();
//			System.out.println(env.toString());
//			env.put("VAR1", "myValue");
//			env.remove("OTHERVAR");
//			env.put("VAR2", env.get("VAR1") + "suffix");
//
//			// pb.directory("myDir");
//			Process p = pb.start();
//			BufferedReader b = new BufferedReader(new InputStreamReader(
//					p.getInputStream()));
//			String line = "";
//			while ((line = b.readLine()) != null) {
//				System.out.println(line);
//			}
			String fn1 =  "IAmARockStar1";
			String fn2 =  "IAmARockStar2";
			echoStringToFile(diff1, fn1); 
			echoStringToFile(diff2, fn2); 
			diffTwoFNs (fn1, fn2);
			rmAFN (fn1);
			rmAFN (fn2);

			//catAFile("IAmRockStar");
		}
	}
	static String rmAFN (String fn) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("rm",fn);
		Process p = pb.start();
		String result = "";
		String line = "";
		BufferedReader b = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		while ((line = b.readLine()) != null) {
			System.out.println(line);
			result += line;
		}
		return result;				
	}
	static String diffTwoFNs (String fn1, String fn2) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("diff",fn1,fn2);
		Process p = pb.start();
		String result = "";
		String line = "";
		BufferedReader b = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		while ((line = b.readLine()) != null) {
			System.out.println(line);
			result += line;
		}
		return result;		
//		pb.directory(new File("."));
//		 File log = new File(fn);
//		 pb.redirectErrorStream(true);
//		 pb.redirectOutput(Redirect.appendTo(log));
//		 Process p = pb.start();
//		 assert pb.redirectInput() == Redirect.PIPE;
//		 assert pb.redirectOutput().file() == log;
//		 assert p.getInputStream().read() == -1;
//		
//		
//		
//		String result = "";
//		String line = "";
//		BufferedReader b = new BufferedReader(new InputStreamReader(
//				p.getInputStream()));
//		while ((line = b.readLine()) != null) {
//			System.out.println(line);
//			result += line;
//		}
//		return result;
		
	}
	static String  echoStringToFile(String str, String fn) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("echo",str);
		//Process p = pb.start();
		
		pb.directory(new File("."));
		 File log = new File(fn);
		 pb.redirectErrorStream(true);
		 pb.redirectOutput(Redirect.appendTo(log));
		 Process p = pb.start();
		 assert pb.redirectInput() == Redirect.PIPE;
		 assert pb.redirectOutput().file() == log;
		 assert p.getInputStream().read() == -1;
		
		
		
		String result = "";
		String line = "";
		BufferedReader b = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		while ((line = b.readLine()) != null) {
			System.out.println(line);
			result += line;
		}
		return result;
	}
	static String catAFile( String fn) throws IOException {
		ProcessBuilder pb = new ProcessBuilder("cat",fn);
		Process p = pb.start();
		BufferedReader b = new BufferedReader(new InputStreamReader(
				p.getInputStream()));
		String result = "";
		String line = "";
		while ((line = b.readLine()) != null) {
			System.out.println(line);
			result += line;
		}
		return result;
	}
    public static final String diff1 = "\"Twinkle twinkle little star\\\\n\"\n" +
            "\t\t\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\";";

    public static final String diff2 = "\"Twinkle twinkle little star\\n\"\n" +
            "\t\t\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twnkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle lttle star\\n\\\";\"\n" +
            "\t\t\t+ \"Twinkle twinkle lttle star\\n\"\n" +
            "\t\t\t+ \"+ \\\"Twinkle twinkle ltitle star\\n\\\";\";";

  
}
