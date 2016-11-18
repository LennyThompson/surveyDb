-- noinspection SqlNoDataSourceInspectionForFile
-- Tables

-- 'Static Data' tables

-- The type of a survey point
-- TODO: Add tables for:
-- InstrumentSetup: Instrument, Height, Location
-- TargetType: ??
-- ImageAnnotation: Text, image location, Colour, Symbol, etc.
-- SurveySketch: Drawing coordinates of sketch of survey detail, could be on image
-- SurveyNote: Dated text
-- SurveySession: date time of start session or end session, with text, instrument, field party?

--* context=global, package_name=com.lenny.surveyingDB

CREATE TABLE `SurveyPointType`
(
    `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `Name` TEXT NOT NULL UNIQUE,
    `Abbreviation`  TEXT NOT NULL UNIQUE,
    `UserDefined` BOOLEAN NOT NULL
);

create trigger UpdateSurveyPointType after update on `SurveyPointType`
    for each row
    begin
        update SurveyPointType set updated = current_timestamp where ID == OLD.ID;
    end;

-- Standard predefined survey point types

INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Survey Mark', 'SM', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Old Survey Mark', 'OSM', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Permanent Survey Mark', 'PSM', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Trig Point', 'Trig', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('General Level', 'GL', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Corner of House', 'Cnr H', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Tree', 'Tree', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Boundary', 'Bdy', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Fence', 'Fnc', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Fence Line', 'FL', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Post', 'Post', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Edge of Concrete', 'EoC', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Edge of Road', 'EoR', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Top of Kerb', 'ToK', 0);
INSERT INTO SurveyPointType (Name, Abbreviation, UserDefined) VALUES ('Drain', 'Dr', 0);

-- The external reference for a survey point

CREATE TABLE `SurveyReference`
(
    `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `Name` TEXT NOT NULL,
    `Description` TEXT NOT NULL,
    `Date`      TIMESTAMP, --* use_as=date_type
    `Reference` TEXT
);

create trigger UpdateSurveyReference after update on `SurveyReference`
    for each row
    begin
        update SurveyReference set updated = current_timestamp where ID == OLD.ID;
    end;

-- Only makes sense to have a current survey for marks created by the survey, and an unknown existing survey...
-- TODO - confirm this. Note that due to a problem with parsing the expression data the '(select cast(strftime('%s', '2000-01-01 00:00:00') as int)' expression has been replaced with the actual timestamp value
INSERT INTO SurveyReference (Name, Description, Date, Reference) VALUES ('Current Survey', 'Current Survey', '2000-01-01 00:00:00', 'No Ref');
INSERT INTO SurveyReference (Name, Description, Date, Reference) VALUES ('Existing Survey', 'Existing Survey', '2000-01-01 00:00:00', 'Unknown reference');

CREATE TABLE InstrumentManufacturer
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `Name`  TEXT NOT NULL UNIQUE,
    `Description`   TEXT
);

create trigger UpdateInstrumentManufacturer after update on `InstrumentManufacturer`
    for each row
    begin
        update InstrumentManufacturer set updated = current_timestamp where ID == OLD.ID;
    end;

CREATE TABLE Instrument
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `Name`  TEXT NOT NULL, --* single_value
    `Description`   TEXT,
    `ManufacturerID` INTEGER,
    FOREIGN KEY (ManufacturerID) REFERENCES InstrumentManufacturer(ID)
);

create trigger UpdateInstrument after update on `Instrument`
    for each row
    begin
        update Instrument set updated = current_timestamp where ID == OLD.ID;
    end;

CREATE TABLE Projection
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `Name`  TEXT NOT NULL,
    `Date`      TIMESTAMP, --* use_as=date_type
    `Description`   TEXT
);

create trigger UpdateProjection after update on `Projection`
    for each row
    begin
        update Projection set updated = current_timestamp where ID == OLD.ID;
    end;

INSERT INTO Projection (Name, Description, Date) VALUES ('UTM XX', 'Transverse Mercator Projection - TODO', '2000-01-01 00:00:00');
INSERT INTO Projection (Name, Description, Date) VALUES ('Local UTM', 'UTM Projection centred on survey', '2000-01-01 00:00:00');

-- Dynamic Data tables

-- Data required for a surveyed point, location, etc. Note that the projection will be (eventually) maintained at the survey level.

CREATE TABLE `SurveyPoint`
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `X` REAL NOT NULL,
    `Y` REAL NOT NULL,
    `Z` REAL NOT NULL,
    `Name`  TEXT,
    `Description`   TEXT,
    `PointTypeID` INTEGER NOT NULL,
    `RefID` INTEGER,
    FOREIGN KEY (PointTypeID) REFERENCES SurveyPointType(ID), --* output_name = PointType
    FOREIGN KEY (RefID) REFERENCES SurveyReference(ID)  --* output_name = Reference
);

create trigger UpdateSurveyPoint after update on `SurveyPoint`
    for each row
    begin
        update SurveyPoint set updated = current_timestamp where ID == OLD.ID;
    end;

-- Table with overriding surveys - base filter for all other data

CREATE TABLE `Survey` --* root
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `Name`  TEXT NOT NULL,
    `ProjectionID` INTEGER NOT NULL,
    `Description`   TEXT,
    FOREIGN KEY (ProjectionID) REFERENCES Projection(ID)  --* output_name = Projection
);

create trigger Survey after update on `Survey`
    for each row
    begin
        update Survey set updated = current_timestamp where ID == OLD.ID;
    end;

-- Survey measurement data, both the from and to points have to already exist in the database.
-- TODO - add instrument reference, measurement type and target type
-- TODO - add GPS measurement type

CREATE TABLE `SurveyMeasurement`
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `SurveyID`  INTEGER NOT NULL,
    `HorizDistance` REAL NOT NULL,
    `VertDistance`  REAL,
    `Bearing`   REAL NOT NULL,
    `FromPtID`  INTEGER NOT NULL,
    `ToPtID`    INTEGER NOT NULL,
    FOREIGN KEY (SurveyID) REFERENCES Survey(ID),  --* parent
    FOREIGN KEY (FromPtID) REFERENCES SurveyPoint(ID), --* output_name = PointFrom
    FOREIGN KEY (ToPtID) REFERENCES SurveyPoint(ID) --* output_name = PointTo
);

create trigger UpdateSurveyMeasurement after update on `SurveyMeasurement`
    for each row
    begin
        update SurveyMeasurement set updated = current_timestamp where ID == OLD.ID;
    end;

-- Table contains data about images taken as part of a survey

CREATE TABLE `SurveyImage`
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `Path`  TEXT NOT NULL,
    `SurveyID` INTEGER NOT NULL, --* read_only, direct_access
    `PointAtID` INTEGER NOT NULL,
    `Description`   TEXT,
    FOREIGN KEY (SurveyID) REFERENCES Survey(ID),
    FOREIGN KEY (PointAtID) REFERENCES SurveyPoint(ID) --* parent, output_name = PointAt
);

create trigger UpdateSurveyImage after update on `SurveyImage`
    for each row
    begin
        update SurveyImage set updated = current_timestamp where ID == OLD.ID;
    end;

-- A traverse is a collection of measurements that constitute a 'closed' set, that is a set of measurements
-- between 2 known points, where the second known point can be the same as the first. Such a traverse can 
-- be adjusted for any errors in the measurements, hence the TraverseClosure table below.

CREATE TABLE `Traverse`
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `Name`  TEXT,
    `Description`   TEXT,
    `SurveyID` INTEGER NOT NULL, --* direct_access
    `StartPointID` INTEGER NOT NULL,
    `EndPointID` INTEGER NOT NULL,
    FOREIGN KEY (SurveyID) REFERENCES Survey(ID), --* parent
    FOREIGN KEY (StartPointID) REFERENCES SurveyPoint(ID), --* output_name = StartPoint
    FOREIGN KEY (EndPointID) REFERENCES SurveyPoint(ID) --* output_name = EndPoint
);

create trigger UpdateTraverse after update on `Traverse`
    for each row
    begin
        update Traverse set updated = current_timestamp where ID == OLD.ID;
    end;

CREATE TABLE `SurveyInstruments`
(
    `SurveyID`  INTEGER NOT NULL,
    `InstrumentID`  INTEGER NOT NULL,
    FOREIGN KEY (InstrumentID) REFERENCES Instrument(ID),
    FOREIGN KEY (SurveyID) REFERENCES Survey(ID), --* parent
    UNIQUE(SurveyID, InstrumentID)
);

-- Parameters to adjust a measurement for errors in a survey.

CREATE TABLE `SurveyAdjustment`
(
    `ID`    INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `MeasurementID` INTEGER NOT NULL, --* parent
    `DeltaX`    REAL NOT NULL,
    `DeltaY`    REAL NOT NULL,
    `DeltaZ`    REAL NOT NULL,
    `BearingAdj`    REAL NOT NULL,
    FOREIGN KEY (MeasurementID) REFERENCES SurveyMeasurement(ID) --* output_name = Measurement
);

create trigger UpdateSurveyAdjustment after update on `SurveyAdjustment`
    for each row
    begin
        update SurveyAdjustment set updated = current_timestamp where ID == OLD.ID;
    end;

-- The 'misclose' from a closed traverse - the calculated coordinate differences and measured bearing
-- difference of the closed traverse.

CREATE TABLE `TraverseClosure` --* import_type = java.util.Date
(
    `ID` INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, --* read_only
	`created`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
	`updated`	TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP, --* use_as=date_type, read_only
    `TraverseID`    INTEGER NOT NULL,
    `MiscZ` REAL,
    `MiscY` REAL,
    `MiscX` REAL,
    `BearingMisclose`   REAL,
    `TraverseLength`    REAL,
    `Adjusted`  BOOLEAN,
    FOREIGN KEY (TraverseID) REFERENCES Traverse(ID) --* parent, output_name = Traverse
);

create trigger UpdateTraverseClosure after update on `TraverseClosure`
    for each row
    begin
        update TraverseClosure set updated = current_timestamp where ID == OLD.ID;
    end;

-- Associates measurements with traverses - a measurement can be more than one traverse (theoretically).

CREATE TABLE `TraverseMeasurement`
(
    `TraverseID`    INTEGER NOT NULL,
    `MeasurementID` INTEGER NOT NULL,
    FOREIGN KEY (MeasurementID) REFERENCES SurveyMeasurement(ID),
    FOREIGN KEY (TraverseID) REFERENCES Traverse(ID), --* parent
    UNIQUE(TraverseID, MeasurementID)
);

-- Associates surveys with points in the survey

CREATE TABLE `SurveyPointLink`
(
    `SurveyID`  INTEGER NOT NULL,
    `SurveyPointID` INTEGER NOT NULL,
    FOREIGN KEY (SurveyPointID) REFERENCES SurveyPoint(ID),
    FOREIGN KEY (SurveyID) REFERENCES Survey(ID), --* parent
    UNIQUE(SurveyPointID, SurveyID)
);


