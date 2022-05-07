import mysql.connector
from mysql.connector import Error

class DatabaseConnection:
    def __init__(self):
        try:
            connection = mysql.connector.connect(host='localhost',
                                                database='dataprocess_data',
                                                user='root',
                                                password='')
            if connection.is_connected():
                db_Info = connection.get_server_info()
                print("Connected to MySQL Server version ", db_Info)
                cursor = connection.cursor()
                cursor.execute("select database();")
                record = cursor.fetchone()
                print("You're connected to database: ", record)

            self.connection = connection

        except Error as e:
            print("Error while connecting to MySQL", e)