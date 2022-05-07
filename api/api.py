from flask import Flask
from flask_cors import CORS
import json
import xml

from database_connection import DatabaseConnection

app = Flask(__name__)
CORS(app)


@app.route("/")
def index():
    return {'hello': 'world'}


def dbSelect(select_query):    
    dbConnection = DatabaseConnection()
    connection = dbConnection.connection
    cursor = connection.cursor()
    cursor.execute(select_query)
    return cursor.fetchall()

@app.route("/select")
def get2015():
    rows = dbSelect('SELECT * FROM `2015`')
    return json.dumps(rows)


if __name__ == '__main__':
    app.run(debug=True)

