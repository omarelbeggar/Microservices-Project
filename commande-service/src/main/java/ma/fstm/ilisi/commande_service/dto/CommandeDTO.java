package ma.fstm.ilisi.commande_service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandeDTO {
private int id;
private Date datecmd;
private int idc;
}
