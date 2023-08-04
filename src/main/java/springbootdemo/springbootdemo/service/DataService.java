
public void insertTeam() throws Exception {

        Connection connection = null;
        Statement statement = null;

        try {

            String user = "themxvog";
            String password = "*****";
            String host = "server236.web-hosting.com";
            int port=21098;

            System.out.println(data.get("team"));

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            session.setPortForwardingL(5522,"127.0.0.1", 3306);

            String connectionUrl = "jdbc:mysql://localhost:5522/themxvog_wp679";
            connection = DriverManager.getConnection(connectionUrl, "themxvog_wp679", "******");


            String query = "insert into nba (team, city, state, mascot) values ('hawks', 'atlanta', 'georgia', 'hawk')";

            statement = connection.createStatement();
            statement.executeUpdate(query);

        } catch (SQLException  e) {
            System.out.println(e.getMessage());
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if(statement != null) {
                statement.close();
            }
        }
    }

Last modified: Wednesday, March 1, 2023, 10:03 AM