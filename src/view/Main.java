package view;

import javax.swing.JOptionPane;

import controller.KillController;


public class Main {
    public static void main(String[] args) {
        KillController TaController = new KillController();

        String os = KillController.os();

        int opc = 0;
        while (opc!=9){
            opc=Integer.parseInt(JOptionPane.showInputDialog("insira comando\n 1-Task List\n 2-TaskKill por id\n 3-TaskKill por nome\n 9-Finalizar\n "));
            switch (opc) {

                case 1:
                    String process = os;
                    TaController.ListaProcessos(process);
                    break;
                case 2:
                    int id =Integer.parseInt(JOptionPane.showInputDialog("Insira o id do processo a ser finalizado"));
                    TaController.mataPID(id);
                    break;
                case 3:
                    String Nome =(JOptionPane.showInputDialog("Insira o id do processo a ser finalizado"));
                    TaController.mataNome(Nome);
                    break;
                default: System.out.println("opc invalida");
                    break;
                case 9:System.out.println("Operação Finalizada");
                    break;
            }

        }
    }
}