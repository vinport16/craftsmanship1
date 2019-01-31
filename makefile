all:
	javac Token.java
	javac AbstractToken.java
	javac Cache.java
	javac Connector.java
	javac TerminalSymbol.java
	javac Variable.java
	javac Node.java
	javac LeafNode.java
	javac InternalNode.java
	javac InternalNodeTests.java
	javac Tests.java

clean:
	rm *.class
	rm org.junit.*