package com.company;


public class Main {

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        BrokerService service = new BrokerService();
        Broker[] brokers = new Broker[3];
        for (int i = 0; i < brokers.length; i++)
            brokers[i] = new Broker(service);


        Client[] clients = new Client[50];

        for (int i = 0; i < clients.length; i++) {
            Client client = new Client(brokers[i % brokers.length]);
            client.autoGetAvailableFlats();
            clients[i] = client;
//                System.out.println(clients[i].toString());
        }
//            clients[0] = new Client(brokers[0]);
//            System.out.println(clients[1].toString());

//            service.printTable();

        for (int i = 0; i < clients.length; i++) {
            clients[i].autoChoose();
        }

        int i = 1;
        for (Broker broker : brokers)
            System.out.println(i++ + ") " + broker.toString());


        i = 1;
        for (Client client : clients)
            System.out.println("Client " + i++ + ": " + client.toString());

        System.out.println("Database: ");
        service.printTable();

    }
}
