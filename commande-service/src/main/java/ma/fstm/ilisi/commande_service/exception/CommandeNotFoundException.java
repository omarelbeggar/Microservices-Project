package ma.fstm.ilisi.commande_service.exception;

public class CommandeNotFoundException extends RuntimeException{
private String message;
public CommandeNotFoundException(String message) {
	
	this.message=message;
}
}
