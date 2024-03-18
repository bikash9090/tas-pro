; Activate the Open window
WinWaitActive("Open")

; Set the file path in the Edit field
ControlSetText("Open", "", "Edit1", "C:\Users\ADMIN\Downloads\stepwise_procedure.pdf")

; Click the Open button
ControlClick("Open", "", "[CLASS:Button; TEXT:&Open]")