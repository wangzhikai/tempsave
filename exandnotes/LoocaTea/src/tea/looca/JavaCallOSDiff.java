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
    static final String diff1 = "{\n" +
            "    \"failures\": null,\n" +
            "    \"transactionIds\": null,\n" +
            "    \"triggers\": [\n" +
            "        {\n" +
            "            \"id\": \"8c38266dc64c4cd98ae7cbc8795f2808\",\n" +
            "            \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "            \"sequences\": [\n" +
            "                {\n" +
            "                    \"name\": \"switchviews\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"id\": \"c83217979356489386bab77b1bed068e\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"direction\": \"down\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_DROP\",\n" +
            "                                \"delay\": \"0.25\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"aea0e983b3be44edba8d4c5f4351d863\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_FADE\",\n" +
            "                                \"delay\": \"0.5\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"15c5b5e336aa401a8e1a3182e7d2d90d\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"direction\": \"horizontal\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_CLIP\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next\"\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"switchviews\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"id\": \"6bd01e53dabf450aa9181f91e94d272a\",\n" +
            "                            \"properties\": {\n" +
            "                                \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"691a89772e394cab8c6458743b948080\",\n" +
            "                            \"properties\": {\n" +
            "                                \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "            \"properties\": {\n" +
            "                \"name\": \"Pick an event 1\"\n" +
            "            },\n" +
            "            \"type\": \"onclick\",\n" +
            "            \"sourceId\": \"19cfeb0a10b84fe1960305b965aae748\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"type\": null\n" +
            "}\n" +
            "15:38:58 INFO  Utilities - Chapter content :\n" +
            "{\n" +
            "    \"content\": {\n" +
            "        \"styleId\": \"e69df92a9fe84451bf1d6e752075b69a\",\n" +
            "        \"id\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "        \"widgets\": [\n" +
            "            {\n" +
            "                \"id\": \"19cfeb0a10b84fe1960305b965aae748\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Button 1\",\n" +
            "                \"children\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    {\n" +
            "                        \"id\": \"8c38266dc64c4cd98ae7cbc8795f2808\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"sequences\": [\n" +
            "                            {\n" +
            "                                \"name\": \"switchviews\",\n" +
            "                                \"actions\": [\n" +
            "                                    {\n" +
            "                                        \"id\": \"c83217979356489386bab77b1bed068e\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"direction\": \"down\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_DROP\",\n" +
            "                                            \"delay\": \"0.25\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"aea0e983b3be44edba8d4c5f4351d863\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_FADE\",\n" +
            "                                            \"delay\": \"0.5\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"15c5b5e336aa401a8e1a3182e7d2d90d\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"direction\": \"horizontal\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_CLIP\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next\"\n" +
            "                                        ]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"name\": \"switchviews\",\n" +
            "                                \"actions\": [\n" +
            "                                    {\n" +
            "                                        \"id\": \"6bd01e53dabf450aa9181f91e94d272a\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"691a89772e394cab8c6458743b948080\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                                        ]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"properties\": {\n" +
            "                            \"name\": \"Pick an event 1\"\n" +
            "                        },\n" +
            "                        \"type\": \"onclick\",\n" +
            "                        \"sourceId\": \"19cfeb0a10b84fe1960305b965aae748\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"hidden\": \"false\",\n" +
            "                    \"value\": \"Button\",\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"0\",\n" +
            "                    \"y\": \"78\",\n" +
            "                    \"push\": \"false\",\n" +
            "                    \"disabled\": \"false\",\n" +
            "                    \"x\": \"286\"\n" +
            "                },\n" +
            "                \"type\": \"BUTTON\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 1\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"3a777c7daa054a569b9c6025d0f38cac\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#8acf58\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"210\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"129\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"c59f59306b8341bbb2cfff4eea834ff7\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#ffbc29\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"1\",\n" +
            "                    \"y\": \"210\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"129\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 3\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"7fea852b8edf4836b941170b82119001\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#a0a0a0\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"77c487ba8e454c6ba61c6e39df84ac03\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#ff0000\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"2\",\n" +
            "                    \"y\": \"218\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"656\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 2\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"f976d78a11ac48f08509b9e37457e8ef\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#00adef\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"a21fa9428df640e0a513727ac791bc21\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#b00000\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"3\",\n" +
            "                    \"y\": \"219\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"397\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"9c7b5c53a737447da7f9179c361aabc8\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Button 3\",\n" +
            "                \"children\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"hidden\": \"false\",\n" +
            "                    \"value\": \"Button\",\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"4\",\n" +
            "                    \"y\": \"86\",\n" +
            "                    \"push\": \"false\",\n" +
            "                    \"disabled\": \"false\",\n" +
            "                    \"x\": \"767\"\n" +
            "                },\n" +
            "                \"type\": \"BUTTON\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "        \"name\": \"Case 1\",\n" +
            "        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "        \"triggers\": [\n" +
            "            \n" +
            "        ],\n" +
            "        \"properties\": {\n" +
            "            \"clip\": \"Horizontal\",\n" +
            "            \"height\": \"600\",\n" +
            "            \"horizontalScroll\": \"Auto\",\n" +
            "            \"width\": \"1000\",\n" +
            "            \"align\": \"Fit to window\",\n" +
            "            \"verticalScroll\": \"Auto\",\n" +
            "            \"media\": \"page\"\n" +
            "        },\n" +
            "        \"type\": \"PAGE\"\n" +
            "    }\n" +
            "}";
    static final String diff2 = "15:37:42 INFO  Utilities - Trigger in Json :\n" +
            "{\n" +
            "    \"failures\": null,\n" +
            "    \"transactionIds\": null,\n" +
            "    \"triggers\": [\n" +
            "        {\n" +
            "            \"id\": \"8c38266dc64c4cd98ae7cbc8795f2808\",\n" +
            "            \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "            \"sequences\": [\n" +
            "                {\n" +
            "                    \"name\": \"switchviews\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"id\": \"c83217979356489386bab77b1bed068e\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"direction\": \"down\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_DROP\",\n" +
            "                                \"delay\": \"0.25\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"aea0e983b3be44edba8d4c5f4351d863\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_FADE\",\n" +
            "                                \"delay\": \"0.5\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                            ]\n" +
            "                        },\n" +
            "                        {\n" +
            "                            \"id\": \"15c5b5e336aa401a8e1a3182e7d2d90d\",\n" +
            "                            \"properties\": {\n" +
            "                                \"duration\": \"1.0\",\n" +
            "                                \"direction\": \"horizontal\",\n" +
            "                                \"transitionType\": \"TRANS_TYPE_CLIP\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next\"\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                },\n" +
            "                {\n" +
            "                    \"name\": \"switchviews\",\n" +
            "                    \"actions\": [\n" +
            "                        {\n" +
            "                            \"id\": \"6bd01e53dabf450aa9181f91e94d272a\",\n" +
            "                            \"properties\": {\n" +
            "                                \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                \"delay\": \"0.0\"\n" +
            "                            },\n" +
            "                            \"type\": \"switchviews\",\n" +
            "                            \"targets\": [\n" +
            "                                \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous\"\n" +
            "                            ]\n" +
            "                        }\n" +
            "                    ]\n" +
            "                }\n" +
            "            ],\n" +
            "            \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "            \"properties\": {\n" +
            "                \"name\": \"Pick an event 1\"\n" +
            "            },\n" +
            "            \"type\": \"onclick\",\n" +
            "            \"sourceId\": \"19cfeb0a10b84fe1960305b965aae748\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"type\": null\n" +
            "}\n" +
            "15:37:42 INFO  Utilities - Chapter content :\n" +
            "{\n" +
            "    \"content\": {\n" +
            "        \"styleId\": \"e69df92a9fe84451bf1d6e752075b69a\",\n" +
            "        \"id\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "        \"widgets\": [\n" +
            "            {\n" +
            "                \"id\": \"19cfeb0a10b84fe1960305b965aae748\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Button 1\",\n" +
            "                \"children\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    {\n" +
            "                        \"id\": \"8c38266dc64c4cd98ae7cbc8795f2808\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"sequences\": [\n" +
            "                            {\n" +
            "                                \"name\": \"switchviews\",\n" +
            "                                \"actions\": [\n" +
            "                                    {\n" +
            "                                        \"id\": \"c83217979356489386bab77b1bed068e\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"direction\": \"down\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_DROP\",\n" +
            "                                            \"delay\": \"0.25\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Hide\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"aea0e983b3be44edba8d4c5f4351d863\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_FADE\",\n" +
            "                                            \"delay\": \"0.5\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f79eb0d2644e12a5872ea075adc36e:Previous\"\n" +
            "                                        ]\n" +
            "                                    },\n" +
            "                                    {\n" +
            "                                        \"id\": \"15c5b5e336aa401a8e1a3182e7d2d90d\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"duration\": \"1.0\",\n" +
            "                                            \"direction\": \"horizontal\",\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_CLIP\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/bfb115b6523749e5a981efea54b21ba1:Next\"\n" +
            "                                        ]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            },\n" +
            "                            {\n" +
            "                                \"name\": \"switchviews\",\n" +
            "                                \"actions\": [\n" +
            "                                    {\n" +
            "                                        \"id\": \"6bd01e53dabf450aa9181f91e94d272a\",\n" +
            "                                        \"properties\": {\n" +
            "                                            \"transitionType\": \"TRANS_TYPE_NONE\",\n" +
            "                                            \"delay\": \"0.0\"\n" +
            "                                        },\n" +
            "                                        \"type\": \"switchviews\",\n" +
            "                                        \"targets\": [\n" +
            "                                            \"/ds/projects/5499c004455a44ccba81f7feb5bde2a4/widgets/48f4a4b07e394f678abb66843f550b65:Previous\"\n" +
            "                                        ]\n" +
            "                                    }\n" +
            "                                ]\n" +
            "                            }\n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"properties\": {\n" +
            "                            \"name\": \"Pick an event 1\"\n" +
            "                        },\n" +
            "                        \"type\": \"onclick\",\n" +
            "                        \"sourceId\": \"19cfeb0a10b84fe1960305b965aae748\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"hidden\": \"false\",\n" +
            "                    \"value\": \"Button\",\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"0\",\n" +
            "                    \"y\": \"78\",\n" +
            "                    \"push\": \"false\",\n" +
            "                    \"disabled\": \"false\",\n" +
            "                    \"x\": \"286\"\n" +
            "                },\n" +
            "                \"type\": \"BUTTON\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 1\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"3a777c7daa054a569b9c6025d0f38cac\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#8acf58\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"210\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"129\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"c59f59306b8341bbb2cfff4eea834ff7\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f4a4b07e394f678abb66843f550b65\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#ffbc29\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"1\",\n" +
            "                    \"y\": \"210\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"129\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 3\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"7fea852b8edf4836b941170b82119001\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#a0a0a0\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"77c487ba8e454c6ba61c6e39df84ac03\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"bfb115b6523749e5a981efea54b21ba1\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#ff0000\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"2\",\n" +
            "                    \"y\": \"218\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"656\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Dynamic Display 2\",\n" +
            "                \"children\": [\n" +
            "                    {\n" +
            "                        \"id\": \"f976d78a11ac48f08509b9e37457e8ef\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                        \"name\": \"Section 1\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#00adef\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"true\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"0\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    },\n" +
            "                    {\n" +
            "                        \"id\": \"a21fa9428df640e0a513727ac791bc21\",\n" +
            "                        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                        \"containerKey\": \"48f79eb0d2644e12a5872ea075adc36e\",\n" +
            "                        \"name\": \"Section 2\",\n" +
            "                        \"children\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                        \"triggers\": [\n" +
            "                            \n" +
            "                        ],\n" +
            "                        \"properties\": {\n" +
            "                            \"clip\": \"No\",\n" +
            "                            \"horizontalScroll\": \"Auto\",\n" +
            "                            \"backgroundColor\": \"#b00000\",\n" +
            "                            \"width\": \"200\",\n" +
            "                            \"push\": \"false\",\n" +
            "                            \"height\": \"150\",\n" +
            "                            \"defaultBranchView\": \"false\",\n" +
            "                            \"hidden\": \"false\",\n" +
            "                            \"layout\": \"absolute\",\n" +
            "                            \"verticalScroll\": \"Auto\",\n" +
            "                            \"locked\": \"false\",\n" +
            "                            \"z\": \"1\",\n" +
            "                            \"y\": \"0\",\n" +
            "                            \"draggable\": \"no\",\n" +
            "                            \"x\": \"0\"\n" +
            "                        },\n" +
            "                        \"type\": \"SECTION\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"3\",\n" +
            "                    \"y\": \"219\",\n" +
            "                    \"rules\": \"None\",\n" +
            "                    \"x\": \"397\"\n" +
            "                },\n" +
            "                \"type\": \"CONDITIONAL_HTML\"\n" +
            "            },\n" +
            "            {\n" +
            "                \"id\": \"9c7b5c53a737447da7f9179c361aabc8\",\n" +
            "                \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "                \"containerKey\": \"8d232a5ce8a54e87a2cf139be3025b46\",\n" +
            "                \"name\": \"Button 3\",\n" +
            "                \"children\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "                \"triggers\": [\n" +
            "                    \n" +
            "                ],\n" +
            "                \"properties\": {\n" +
            "                    \"hidden\": \"false\",\n" +
            "                    \"value\": \"Button\",\n" +
            "                    \"locked\": \"false\",\n" +
            "                    \"z\": \"4\",\n" +
            "                    \"y\": \"86\",\n" +
            "                    \"push\": \"false\",\n" +
            "                    \"disabled\": \"false\",\n" +
            "                    \"x\": \"767\"\n" +
            "                },\n" +
            "                \"type\": \"BUTTON\"\n" +
            "            }\n" +
            "        ],\n" +
            "        \"chapterId\": \"de3c3b8ef048490096bae88ad586ee41\",\n" +
            "        \"name\": \"Case 1\",\n" +
            "        \"projectId\": \"5499c004455a44ccba81f7feb5bde2a4\",\n" +
            "        \"triggers\": [\n" +
            "            \n" +
            "        ],\n" +
            "        \"properties\": {\n" +
            "            \"clip\": \"Horizontal\",\n" +
            "            \"height\": \"600\",\n" +
            "            \"horizontalScroll\": \"Auto\",\n" +
            "            \"width\": \"1000\",\n" +
            "            \"align\": \"Fit to window\",\n" +
            "            \"verticalScroll\": \"Auto\",\n" +
            "            \"media\": \"page\"\n" +
            "        },\n" +
            "        \"type\": \"PAGE\"\n" +
            "    }\n" +
            "}";


}
