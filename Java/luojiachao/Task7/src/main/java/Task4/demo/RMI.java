//public interface Compute extends Remote {
//    <T> T executeTask(Task<T> t) throws RemoteException;
//}
//
//    String name = "Compute";
//    Compute engine = new ComputeEngine();
//    Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0); // anonymous port
//    Registry registry = LocateRegistry.createRegistry(1099);
//    registry.bind(name, stub);
//
//
//            String name = "Compute";
//            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1099);
//            Compute comp = (Compute) registry.lookup(name);
//            Pi task = new Pi();
//            BigDecimal pi = comp.executeTask(task);
