Titanic_Data = LOAD '/exam/Titanic.csv' USING PigStorage(',') AS
(
	Name: chararray,
	PClass: chararray,
	Age: int
	Sex: chararray,
	Survived: int,
	SexCode: int
);

DUMP COUNT(Titanic_Data)