Copyright 2002 Joaquin Moreno Guzmán Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.

# GRAFOS #
## ¿QUE ES UN GRAFO? ##
Un grafo en su totalidad es un par ordenado compuesto por vértices (v) y aristas (e); donde en la gran mayoría de los casos los vértices son de cuantificación finita. El número de vértices que componen al grafo, son las que conocemos como orden.

## ¿COMO FUNCIONA LA CLASE GRAPH? ##
La clase Graph.java contiene los métodos necesarios para poder ejecutar los tests. El metodo addVertex() añade un vértice al grafo, addEdge() añade una arista entre dos vértices. El metodo containsVertex() nos dice si el grafo contiene un vertice. El metodo obtainAdjacents() obtiene el conjunto de vertices adyacentes a otro. El metodo toString() esta reescrito para que que devuelva una cadena con cada vertice existente en el grafo y sus adyacentes. El metodo onePath() encuentra un camino entre dos vertices en caso de que estén conectados. 

## ¿COMO FUNCIONA LA CLASE GRAPHTEST ##
La clase GraphTest.java contiene los tests necesarios para verificar el correcto funcionamiento de los diferentes metodos.

## COMANDOS NECESARIOS ##
Para realizar los tests escribimos el comando "mvn test"
Para compilar utilizamos el comando "mvn compile"
Para generar el javadoc ejecutar el comando "mvn site"
Para generar el jar "mvn compile assembly:single"