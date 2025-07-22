package api.cliente.springboot2.util;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component // Marca esta classe como um componente Spring. Isso a torna um "bean" gerenciável pelo contêiner de Inversão de Controle (IoC) do Spring.
public class DateUtil {


    public String formatLocalDateTimeToDatabaseStyle(LocalDateTime localDateTime){
        // Retorna a data e hora formatada usando um padrão específico.
        // "yyyy-MM-dd HH:mm:ss" é um formato universalmente reconhecido para timestamps em bancos de dados.
        return DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(localDateTime);
    }
}
