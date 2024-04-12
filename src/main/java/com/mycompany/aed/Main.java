package com.mycompany.aed;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear una instancia de conexión a MongoDB
        ConexionMongoDB conexionMongoDB = new ConexionMongoDB();

        // Obtener la instancia de la base de datos
        MongoDatabase database = conexionMongoDB.getDatabase();

        // Obtener la colección "persona" (o crearla si no existe)
        MongoCollection<Document> collection = database.getCollection("Persona");

        // Pedir al usuario que ingrese los datos de la persona
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la persona:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el DNI de la persona:");
        String dni = scanner.nextLine();
        System.out.println("Ingrese el número de celular de la persona:");
        String celular = scanner.nextLine();

        // Crear un nuevo documento con los datos ingresados por el usuario
        Document docPersona = new Document("dni", dni)
                .append("nombre", nombre)
                .append("celular", celular);

        // Insertar el documento en la colección "persona"
        collection.insertOne(docPersona);

        // Imprimir mensaje de confirmación
        System.out.println("Documento insertado correctamente en la colección 'persona'.");

        // Cerrar la conexión con MongoDB
        conexionMongoDB.cerrarConexion();
    }
}



