package ma.fstm.ilisi.client_service.external;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




public class Commande {

private int id;
private Date datecmd;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getDatecmd() {
	return datecmd;
}
public void setDatecmd(Date datecmd) {
	this.datecmd = datecmd;
}

}

