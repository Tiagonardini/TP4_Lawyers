package ejercicio0.database;

import java.time.LocalDateTime;

public record VentaData(long idVenta, LocalDateTime fechaDeVenta,
                        float montoTotal,
                        float litrosCargados, String tipo) {
}
