package model;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.ArrayList;

public class Tool {

    private String name;
    private final ArrayList<User> userList = new ArrayList<>();

    private final ArrayList<Process> processList = new ArrayList<>();

    public Tool(String name) {
        super();
        this.name = name;

        initialistData();
    }

    public Tool() {
        super();
        initialistData();
    }

    public boolean userExist(String mail) {
        for (User user : userList) {
            if (user.getMail().equals(mail)) {
                return true;
            }
        }
        return false;
    }

    public User searchUser(String mail) throws UserDoesntExistException {
        for (User user : userList) {
            if (user.getMail().equals(mail)) {
                return user;
            }
        }
        throw new UserDoesntExistException();
    }

    public void addUser(User user) throws UserAlreadyExistException {
        if (!userExist(user.getUserName())) {
            userList.add(user);
        } else
            throw new UserAlreadyExistException();
    }

    public void createUser(String userName, String password, UserType userType, String mail, NotificationType notificationType) {
        try {
            addUser(new User(userType, userName, password, mail, notificationType));
        } catch (UserAlreadyExistException e) {
            ShowMessage.mostrarMensaje("Error", "Error al crear el usuario", "El usuario ya existe");
        }
    }

    public boolean delete(User user) {
        return userList.remove(user);
    }

    public boolean deleteUser() throws UserDoesntExistException {
        if (userExist(name))
            return delete(searchUser(name));
        else
            throw new UserDoesntExistException();
    }

    public void addProcess(Process process) {
        if (!processList.contains(process))
            processList.add(process);
        else
            try {
                throw new ProcessAlreadyExist();
            } catch (Exception e) {
                ShowMessage.mostrarMensjae("Error", "Error al agregar el proceso", "El proceso ya existe");
            }
    }

    public Process searchProcess(String name) {
        for (Process process : processList) {
            if (process.getName().equals(name)) {
                return process;
            }
        }
        return null;
    }

    public void createProcess(String name, String id) {
        addProcess(new Process(name, id));
    }

    public void delete(Process process) {
        processList.remove(process);
    }

    public void deleteProcess(String name) {
        for (Process process : processList) {
            if (process.getName().equals(name)) {
                delete(process);
                return;
            }
        }
    }

    public boolean isAdmin(String name) {
        for (User user : userList) {
            if (user.getUserName().equals(name)) {
                return user.getUserType().equals(UserType.ADMINISTRATOR);
            }
        }
        return false;
    }

    public void notifyUser(String message) {
        if ((INSTANCE.getCurretnUser().getTypeNotification().equals(NotificationType.MAIL))) ;
        Mail mail = new Mail(INSTANCE.getCurrentUser().getMail(), "Notification", message);
        mail.sendMail();
    }else
            Platform.runLater(()->{




        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Éxito");
        alert.setHeaderText(null);
        alert.setContentText(message);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            //Se pueden agregar más acciones depues de hacer click en "OK"
        }
    });

}


