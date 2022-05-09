from asyncio import constants
from flask import Flask, Response
from flask_cors import CORS
from decimal import Decimal
from json import dumps

from database_connection import DatabaseConnection

import json
import xml
import csv

app = Flask(__name__)
CORS(app)

class JSONEncoder(json.JSONEncoder):
    def default(self, obj):
        if isinstance(obj, Decimal):
            return float(obj)
        return json.JSONEncoder.default(self, obj)

def dbSelect(select_query):    
    dbConnection = DatabaseConnection()
    connection = dbConnection.connection
    cursor = connection.cursor()
    cursor.execute(select_query)
    return cursor.fetchall()

@app.route("/", methods=['GET'])
def index():
    return Response(dumps({
        'content': 'Hello world'
    }), mimetype='text/json')

@app.route("/deathcauses")
def getdeathcauses():
    rows = dbSelect('SELECT * FROM `deathcausepercountry2020`')
    return json.dumps(rows)
     

@app.route("/globalhappiness")
def getglobalhappiness():
    rows = dbSelect('SELECT * FROM `globalhappiness2019`')
    return json.dumps(rows ,cls=JSONEncoder)

@app.route("/height")
def getheightpercountry():
    rows = dbSelect('SELECT * FROM `heightpercountry2022`')
    return json.dumps(rows ,cls=JSONEncoder)

if __name__ == '__main__':
    app.run(debug=True)


