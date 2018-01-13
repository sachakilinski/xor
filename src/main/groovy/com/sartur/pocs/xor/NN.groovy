package com.sartur.pocs.xor

class NN {
    List<Node> nodes
    List<Link> links
    NN(Integer[] topology) {
        this.nodes = createNodes(topology)
        this.links = createLinks(topology, this.nodes)
    }

    private List<Node> createNodes(Integer[] topology){
        List<Node> createdNodes = []
        for (int layer=0; layer < topology.size(); layer++){
            for(int position=0; position < topology[layer]; position++){
                createdNodes.add(new Node(layer: layer, position: position))
            }
        }
        createdNodes
    }

    private List<Link> createLinks(Integer[] topology, List<Node> nodes) {
        List<Link> createdLinks = []

        for (int layer = 0; layer < topology.size() -1; layer++) {
            for (int position = 0; position < topology[layer]; position++) {
                for(int nextLayerPosition = 0; nextLayerPosition < topology[layer + 1]; nextLayerPosition++){
                    Double weight = Math.random()
                    createdLinks.add(new Link( inNode: findNode(layer, position), outNode: findNode(layer + 1, nextLayerPosition), weight: weight))
                    println( "${layer},${position} -> ${layer + 1},${nextLayerPosition} - W = ${weight}")
                }
            }
        }

        createdLinks
    }

    private Node findNode(int layer, int position){
        nodes.find{ Node it -> it.layer == layer && it.position == position }
    }
}
