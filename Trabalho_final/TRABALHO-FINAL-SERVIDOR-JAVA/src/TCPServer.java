import java.io.*;
import java.net.*;
import com.google.gson.Gson;

class TCPServer {
	public static void main(String args[]) throws Exception {

		int porta = 12000;
		String request;
		String reply;

		ServerSocket server = new ServerSocket(porta);

		System.out.println("aguardando conexão! na porta " + porta);

		while (true) {
			try {
				
				Gson gson = new Gson();

				Socket cliente = server.accept();

				System.out.println(cliente.getRemoteSocketAddress() + " Conectou-se");
				System.out.println();

				BufferedReader in = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
				PrintWriter out = new PrintWriter(cliente.getOutputStream(), true);

				request = in.readLine();
				System.out.println("Received JSON: " + request);
				System.out.println();
				

				Menssagem msg = gson.fromJson(request, Menssagem.class);
				System.out.println();
				System.out.println(msg);
				System.out.println();

				int method = msg.getMethodId();
				Argumentos argumentos = msg.getArguments();
				
				String json = "";
				
				if(msg.getMessageType() == 1)
					continue;

				switch (method) {
				case 1:
					reply = Integer.toHexString(msg.getArguments().getDecimal());

					argumentos.setResposta("" + reply);
					msg.setMessageType(1);
					json = gson.toJson(msg);
					try {
						FileWriter writer = new FileWriter("file.json");
						writer.write(json);
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					out.println(json);
					break;
				case 2:
					reply = Integer.toBinaryString(msg.getArguments().getDecimal());

					argumentos.setResposta("" + reply);
					msg.setMessageType(1);
					json = gson.toJson(msg);
					try {
						FileWriter writer = new FileWriter("C:\\file.json");
						writer.write(json);
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					out.println(json);
					break;
				case 3:
					reply = Integer.toOctalString(msg.getArguments().getDecimal());

					argumentos.setResposta("" + reply);
					msg.setMessageType(1);
					json = gson.toJson(msg);
					try {
						FileWriter writer = new FileWriter("C:\\file.json");
						writer.write(json);
						writer.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
					out.println(json);
					break;
				
				default:
					break;
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}

			
		}
	}
}