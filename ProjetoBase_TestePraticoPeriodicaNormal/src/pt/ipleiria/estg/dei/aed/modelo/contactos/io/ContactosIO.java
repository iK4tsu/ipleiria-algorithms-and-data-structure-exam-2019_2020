package pt.ipleiria.estg.dei.aed.modelo.contactos.io;

import pt.ipleiria.estg.dei.aed.modelo.contactos.Contacto;
import pt.ipleiria.estg.dei.aed.modelo.contactos.Data;

import java.io.*;
import java.util.InvalidPropertiesFormatException;

public class ContactosIO {

    public static Contacto[] lerContactos(File ficheiro) {
        try (BufferedReader br = new BufferedReader(new FileReader(ficheiro))) {
            String primeiraLinha = br.readLine().trim();
            int numContactos = Integer.parseInt(primeiraLinha);
            Contacto[] contactos = new Contacto[numContactos];
            String linha = null;
            int num = 0;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length != 5) {
                    throw new InvalidPropertiesFormatException("Contacto inválido");
                }
                contactos[num++] = new Contacto(partes[0], partes[1], Long.parseLong(partes[2]), partes[3], Data.parseData(partes[4]));
            }
            if (num != numContactos) {
                throw new InvalidPropertiesFormatException("Número de contactos incorreto");
            }

            return contactos;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Contacto[0];
    }

    public static void escreverContactos(File ficheiro, Contacto[] contactos) {
        try (PrintWriter pw = new PrintWriter(ficheiro)) {
            pw.println(contactos.length);
            for (Contacto c : contactos) {
                pw.println(c.getPrimeiroNome() + "," + c.getUltimoNome() + "," + c.getNumeroTelefone() + "," + c.getMorada() + "," + c.getDataNascimento().toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
