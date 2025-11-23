package Consola.GUI;

public class MonitoreoRedWiFiGUI {

    private static double ultimaVelocidad = -1;
    private static double ultimaLatencia = -1;

    public void realizarPruebaVelocidad() {
        ultimaVelocidad = Math.random() * 100;  // Mbps
        System.out.println("Prueba de velocidad completada.");
        System.out.println("Velocidad medida: " +
                String.format("%.2f", ultimaVelocidad) + " Mbps");
    }

    public void realizarPruebaLatencia() {
        ultimaLatencia = Math.random() * 50; // ms
        System.out.println("Prueba de latencia completada.");
        System.out.println("Latencia medida: " +
                String.format("%.2f", ultimaLatencia) + " ms");
    }

    public void mostrarResultados() {
        System.out.println("===== RESULTADOS DE PRUEBAS =====");

        if (ultimaVelocidad == -1 && ultimaLatencia == -1) {
            System.out.println("Aún no se han realizado pruebas.");
            return;
        }

        if (ultimaVelocidad != -1)
            System.out.println("Última velocidad: " +
                    String.format("%.2f", ultimaVelocidad) + " Mbps");

        if (ultimaLatencia != -1)
            System.out.println("Última latencia: " +
                    String.format("%.2f", ultimaLatencia) + " ms");
    }
}

