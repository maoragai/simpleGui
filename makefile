# 305544546
# Agaimao
compile: bin
	javac -cp src -d bin src/Ball.java src/BouncingBallAnimation.java src/Line.java src/MultipleBouncingBallsAnimation.java src/MultipleFramesBouncingBallsAnimation.java src/Point.java src/SimpleGuiExample.java src/Velocity.java



run2:
	java -cp bin SimpleGuiExample

run3.2:
	java -cp bin BouncingBallAnimation

run3.3:
	java -cp bin MultipleBouncingBallsAnimation
run3.4:
	java -cp bin MultipleFramesBouncingBallsAnimation
bin:
	mkdir bin
