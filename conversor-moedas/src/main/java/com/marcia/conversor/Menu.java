package com.marcia.conversor;

import java.util.Scanner;

public class Menu {

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        Request request = new Request();

        while (true) {
            System.out.println("\n=== Conversor de Moedas ===");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Real para Dólar");
            System.out.println("2 - Real para Euro");
            System.out.println("3 - Real para Libra");
            System.out.println("4 - Dólar para Real");
            System.out.println("5 - Euro para Real");
            System.out.println("6 - Libra para Real");
            System.out.println("7 - Sair");
            System.out.println("8 - Usar a interface gráfica");
            System.out.print("Opção: ");

            int opcao = scanner.nextInt();

            if (opcao == 8) {
                // Abrir GUI
                javax.swing.SwingUtilities.invokeLater(() -> new ConversorGUI());
                System.out.println("Abrindo interface gráfica...");
                scanner.close();
                // Encerra o programa para não continuar o menu console
                System.exit(0);
            }

            String base = null;
            String target = null;

            switch (opcao) {
                case 1:
                    base = "BRL";
                    target = "USD";
                    break;
                case 2:
                    base = "BRL";
                    target = "EUR";
                    break;
                case 3:
                    base = "BRL";
                    target = "GBP";
                    break;
                case 4:
                    base = "USD";
                    target = "BRL";
                    break;
                case 5:
                    base = "EUR";
                    target = "BRL";
                    break;
                case 6:
                    base = "GBP";
                    target = "BRL";
                    break;
                case 7:
                    System.out.println("Saindo...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida!");
                    continue;
            }

            System.out.print("Digite o valor a converter: ");
            double valor = scanner.nextDouble();

            Rates rates = request.baixaRate(base, target, valor);

            if ("success".equalsIgnoreCase(rates.getResult())) {
                double taxaCambio = rates.getConversion_rate();
                double convertido = valor * taxaCambio;

                System.out.printf("Taxa de câmbio: %.2f%n", taxaCambio);
                System.out.printf("Valor convertido: %.2f %s%n", convertido, target);
            } else {
                System.out.println("Erro ao obter a taxa de câmbio. Tente novamente.");
            }
        }
    }
}
