##Introduction

This project aims to address the problems involved in Mobile to Web communications.

We currently have developed only on J2ME and expect to roll-out to other platforms (Including Android, iPhone). Support is needed from the community to establish this as a standardized communications framework. The following is a description of how the framework operates:

* You can add a paramater to the request
* You can add a file to the request
* You can add a photo to the request

##Sample J2ME Request

	private boolean sendToServer() {
        boolean isSuccessful = false;

        Message message = new Message();

        // Add 2 parameters

        message.addParameter("parameterA", valueATextField.getString());
        message.addParameter("parameterB", valueBTextField.getString());

        // Add a photo and a file

        message.addPhoto("parameterC", photoBytes);
        message.addFile("parameterD", fileBytes);

        try {
            ServerCommunication serverCommunication = new ServerCommunication("http://localhost:8080/MobiWebTest/APITest", true);
            ServerResponse serverResponse = serverCommunication.sendPostMessage(message);
            serverCommunication.closeConnection();

            if(serverResponse.getStatusMessage().equals("error")) {
                isSuccessful = false;
            }
            else {
                returnMessage = serverResponse.getMainMessage().toString();
                isSuccessful = true;
            }

        } catch (ConnectionException ex) {
            ex.printStackTrace();
            return false;
        }
        
        return isSuccessful;
    }
    
##Explanation

The code above sends a request to the server and combines multiple fields into one server request.

* Parameters A and B are both sent to the server as hidden fields.
* Parameter C and D are sent as files or file uploads via HTTP.

This means that the server code will need to handle these requests and on successful execution the mobile client is told of the result ("error") means something went wrong.