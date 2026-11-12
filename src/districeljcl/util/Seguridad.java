/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package districeljcl.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Seguridad {
    
     private static final String ALGORITMO =
            "PBKDF2WithHmacSHA256";

    private static final int ITERACIONES = 600000;

    private static final int TAMANO_SALT = 16;

    private static final int TAMANO_HASH = 256;

    private static final SecureRandom RANDOM = new SecureRandom();

    // Genera un hash seguro a partir de una contraseña.
    public static String generarHash(String contrasena) {

        if (contrasena == null || contrasena.isEmpty()) {
            throw new IllegalArgumentException(
                    "La contraseña no puede estar vacía."
            );
        }

        byte[] salt = new byte[TAMANO_SALT];

        RANDOM.nextBytes(salt);

        byte[] hash = derivarHash(
                contrasena.toCharArray(),
                salt,
                ITERACIONES
        );

        return "PBKDF2$"
                + ITERACIONES + "$"
                + Base64.getEncoder().encodeToString(salt) + "$"
                + Base64.getEncoder().encodeToString(hash);
    }

    // Verifica una contraseña frente a un hash almacenado.
    public static boolean verificarContrasena(
            String contrasena,
            String hashAlmacenado) {

        if (contrasena == null || hashAlmacenado == null) {
            return false;
        }

        try {

            String[] partes = hashAlmacenado.split("\\$");

            if (partes.length != 4) {
                return false;
            }

            if (!partes[0].equals("PBKDF2")) {
                return false;
            }

            int iteraciones = Integer.parseInt(partes[1]);

            if (iteraciones < 1 || iteraciones > 1000000) {
                return false;
            }

            byte[] salt = Base64.getDecoder().decode(partes[2]);

            byte[] hashOriginal =
                    Base64.getDecoder().decode(partes[3]);

            if (salt.length != TAMANO_SALT
                    || hashOriginal.length != TAMANO_HASH / 8) {
                return false;
            }

            byte[] hashIngresado = derivarHash(
                    contrasena.toCharArray(),
                    salt,
                    iteraciones
            );

            return java.security.MessageDigest.isEqual(
                    hashOriginal,
                    hashIngresado
            );

        } catch (IllegalArgumentException e) {

            return false;

        }
    }

    // Realiza la derivación criptográfica de la contraseña.
    private static byte[] derivarHash(
            char[] contrasena,
            byte[] salt,
            int iteraciones) {

        PBEKeySpec especificacion = new PBEKeySpec(
                contrasena,
                salt,
                iteraciones,
                TAMANO_HASH
        );

        try {

            SecretKeyFactory fabrica =
                    SecretKeyFactory.getInstance(ALGORITMO);

            return fabrica.generateSecret(especificacion).getEncoded();

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {

            throw new IllegalStateException(
                    "No fue posible generar el hash de la contraseña.",
                    e
            );

        } finally {

            especificacion.clearPassword();

            java.util.Arrays.fill(contrasena, '\0');

        }
    }

    
}
