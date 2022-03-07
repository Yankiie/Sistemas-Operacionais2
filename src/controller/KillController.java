package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class KillController {
    public static String os() {
        String os = System.getProperty("os.name");
        return os;
    }
    public void ListaProcessos(String process) {
        String os = KillController.os();
        if (os.contains("Windows")) {
            try {
                Process p = Runtime.getRuntime().exec("tasklist /fo table");
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null) {
                    System.out.println(linha);
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {if (os.contains("Linux")) {
            try {
                Process p = Runtime.getRuntime().exec("ps -ef");
                InputStream fluxo = p.getInputStream();
                InputStreamReader leitor = new InputStreamReader(fluxo);
                BufferedReader buffer = new BufferedReader(leitor);
                String linha = buffer.readLine();
                while (linha != null) {
                    System.out.println(linha);
                    linha = buffer.readLine();
                }
                buffer.close();
                leitor.close();
                fluxo.close();
            } catch (IOException e) {
                e.printStackTrace();
                  }
             }
        }
    }
    public void mataPID (int id) {
        String os = KillController.os();
        if (os.contains("Windows")) {
            String 	cmdPid = "taskkill /PID";
            int pid=(id);
            StringBuffer buffer = new StringBuffer();
            buffer.append(cmdPid);
            buffer.append(" ");
            buffer.append(pid);
            try {
                Runtime.getRuntime().exec(buffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{if (os.contains("Linux")) {
            String 	cmdPid = "kill -9";
            int pid=(id);
            StringBuffer buffer = new StringBuffer();
            buffer.append(cmdPid);
            buffer.append(" ");
            buffer.append(pid);
            try {
                Runtime.getRuntime().exec(buffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
    }
    public void mataNome (String Nome) {
        String os = KillController.os();
        if (os.contains("Windows")) {
            String 	cmdNome = "taskkill /IM";
            StringBuffer buffer = new StringBuffer();
            buffer.append(cmdNome);
            buffer.append(" ");
            buffer.append(Nome);
            try {
                Runtime.getRuntime().exec(buffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{if (os.contains("Linux")) {
            String 	cmdNome = "pkill -f";
            StringBuffer buffer = new StringBuffer();
            buffer.append(cmdNome);
            buffer.append(" ");
            buffer.append(Nome);
            try {
                Runtime.getRuntime().exec(buffer.toString());
            } catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
    }
}
