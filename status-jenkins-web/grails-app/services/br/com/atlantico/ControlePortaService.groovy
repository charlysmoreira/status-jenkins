package br.com.atlantico

import gnu.io.CommPortIdentifier
import gnu.io.NoSuchPortException
import gnu.io.SerialPort

class ControlePortaService {

    OutputStream serialOut;
    SerialPort port = null;

    ConfiguracaoTO configuracaoTO

    public ControlePorta() {}

    /**
     * Responsavel por abrir uma conexao com a porta serial,
     * Retorna a controladora
     */
    public void abrirPorta() {
        CommPortIdentifier portId = null;
        try {
            portId = CommPortIdentifier.getPortIdentifier(configuracaoTO.porta);
            port = (SerialPort) portId.open("Comunicacao com serial", configuracaoTO.boutRate);
            port.setSerialPortParams(configuracaoTO.boutRate, //taxa de transferencia da porta serial
                    SerialPort.DATABITS_8, //taxa de 10 bits 8 (envio)
                    SerialPort.STOPBITS_1, //taxa de 10 bits 1 (recebimento)
                    SerialPort.PARITY_NONE); //receber e enviar dados
            serialOut = port.getOutputStream();
        }catch (NoSuchPortException npe) {
            println("Porta Serial nao encontrada, verifique!");
        }
    }
    /**
     * Responsavel por fechar a porta serial
     */
    public void fecharPorta() {
        try {
            serialOut.close();
            port.close();
        }catch (Exception e) {
            println("Nao foi possivel fechar a porta serial. " + e.getMessage());
        }
    }
    /**
     * @param opcao - Responsavel por enviar os dados para porta serial
     */
    public void enviaDados(int opcao){
        try {
            serialOut.write(opcao);//escreve o valor na porta serial para ser enviado
            println(opcao == 1 ? "verde" : "vermelho");
        } catch (IOException ex) {
            println("Nao foi possivel enviar o dado, " + opcao + " - " + ex.getMessage());
        }
    }
}
