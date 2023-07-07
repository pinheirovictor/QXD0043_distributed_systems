
public class Menssagem {
	
	private int messageType;
	private int requestId;
	private int methodId;	
	private String objectReference;
	private Argumentos arguments;
	
	
	
	public Menssagem(int messageType, int requestId, int methodId, String objectReference, Argumentos arguments) {
		super();
		this.messageType = messageType;
		this.requestId = requestId;
		this.methodId = methodId;
		this.objectReference = objectReference;
		this.arguments = arguments;
	}
	
	public int getMessageType() {
		return messageType;
	}
	public void setMessageType(int messageType) {
		this.messageType = messageType;
	}
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getMethodId() {
		return methodId;
	}
	public void setMethodId(int methodId) {
		this.methodId = methodId;
	}
	public String getObjectReference() {
		return objectReference;
	}
	public void setObjectReference(String objectReference) {
		this.objectReference = objectReference;
	}
	public Argumentos getArguments() {
		return arguments;
	}
	public void setArguments(Argumentos arguments) {
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		return "Menssagem [messageType=" + messageType + ", requestId=" + requestId + ", methodId=" + methodId
				+ ", objectReference=" + objectReference + ", arguments=" + arguments + "]";
	}
	
	
}
