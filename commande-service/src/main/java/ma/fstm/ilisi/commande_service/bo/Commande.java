package ma.fstm.ilisi.commande_service.bo;

import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Commande {
@Id
private int id;
private Date datecmd;
private int idc;
}
