package ma.fstm.ilisi.client_service.exception;

public class ClientNotFoundException extends RuntimeException{
private String message;
public ClientNotFoundException(String message) {
	
	this.message=message;
}
}
