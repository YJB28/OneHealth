-- create database pratik_patient;
-- use pratik_patient;

CREATE TABLE doctor_registration (
    Profile_ID SERIAL PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50),
    Password VARCHAR(30),
    Email_Id VARCHAR(100),
    License_Number VARCHAR(50),
    Specialization VARCHAR(100),
    Account_status VARCHAR(100),
    Count BIGINT
);

 CREATE TABLE Specialities (
    Spec_ID SERIAL PRIMARY KEY,
    Spec_Name VARCHAR(50),
    Spec_Description TEXT
);


CREATE TABLE Super_Admin (
    Admin_id SERIAL PRIMARY KEY,
    Name VARCHAR(50) NOT NULL,
    Email_ID VARCHAR(100) NOT NULL,
    Password VARCHAR(50) NOT NULL,
    Contact VARCHAR(15) NOT NULL
);

CREATE TABLE doctor_profile (
    Doctor_id SERIAL primary key,
    Profile_ID INT REFERENCES doctor_registration (Profile_ID),
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50),
    Email_ID VARCHAR(50),
    Contact BIGINT,
    Gender VARCHAR(10),
    Address VARCHAR(100),
    Pincode INTEGER,
    City VARCHAR(30),
    State VARCHAR(30),
    DOB DATE,
    Spec_id int  references Specialities (Spec_ID),
    Degree VARCHAR(100),
    YearPassout INT,
    DegreeUniversity VARCHAR(200),
    Experience INT,
    Biography TEXT,
    Photo VARCHAR(255),
    PAN_CARD_doc VARCHAR(255),
    Gst_certificate_doc VARCHAR(255),
    Degree_certificate_doc VARCHAR(255),
    Adhar_card_doc VARCHAR(255),
    Associated_with VARCHAR(50)

);



CREATE TABLE Doc_Auth (

    Auth_id SERIAL PRIMARY KEY,

    Profile_id INT REFERENCES Doctor_registration(Profile_id),

    Admin_id INT references super_admin (admin_id),

    Status VARCHAR(30) DEFAULT 'InReview',

    Description TEXT

);




CREATE TABLE Audit (

    Audit_Id SERIAL PRIMARY KEY,

    Table_Name VARCHAR(30) NOT NULL,

    Record_id INT NOT NULL,

    Action VARCHAR(30) NOT NULL,

    Old_Data TEXT,

    New_Data TEXT,

    Column_Modified VARCHAR(30),

    Type_User VARCHAR(30),

    User_ID INT,

    TimeStamp TIMESTAMP

);



 
CREATE TABLE Doctor_Bank_Details (
    Doctor_id INT REFERENCES doctor_profile (Doctor_id),
    BankName VARCHAR(100),
    AccountNumber VARCHAR(50),
    IFSCCode VARCHAR(20),
    UPI_ID VARCHAR(255),
    BranchAddress VARCHAR(200),
    GSTNumber VARCHAR(15),
    PanCardNumber VARCHAR(15),
    AadharNumber BIGINT
);

 


CREATE TABLE Doctor_Schedule (
    Slot_id SERIAL PRIMARY KEY,
    Doctor_id INT REFERENCES Doctor_profile (Doctor_id),
    Date DATE,
    Start_Time TIME,
    End_Time TIME,
    Type_of_availability  VARCHAR(30),
    Address_of_availability TEXT
);

CREATE TABLE User_registration (
    User_ID SERIAL PRIMARY KEY,
    First_Name VARCHAR(50),
    Last_Name VARCHAR(50),
    Password VARCHAR(30),
    EmailID VARCHAR(100)
);

 
CREATE TABLE Patient_profile (
    Patient_id SERIAL PRIMARY KEY,
    User_ID INT REFERENCES User_registration (User_ID),
    Mobile_Number BIGINT,
    Address VARCHAR(100),
    Pin_Code INTEGER,
    Country VARCHAR(50),
    City VARCHAR(30),
    Gender VARCHAR(10),
    Age INT,
    DOB DATE,
    Blood_Group VARCHAR(10),
    Height DECIMAL(5,2),
    Weight DECIMAL(5,2),
    Marital_status VARCHAR(20),
    Email_add VARCHAR(100)
);


CREATE TABLE Appointment (
    AppointmentID SERIAL PRIMARY KEY,
    Doctor_id INT REFERENCES Doctor_profile (Doctor_id),
    Patient_id INT REFERENCES Patient_profile (Patient_id),
    AppointmentDate DATE,
    AppointmentTime TIME,
    Status VARCHAR(20),
    CreatedAt TIMESTAMP,
    Type VARCHAR(50),
    Payment_Mode VARCHAR(50),
    Transaction_id VARCHAR(50),
    Address TEXT,
    Amount_paid    Decimal  
);

 


CREATE TABLE patient_doctor_relation (
    Doctor_id INT references doctor_profile (Doctor_id),
    Patient_ID INT references patient_profile (Patient_id),
    PRIMARY KEY (Doctor_id, Patient_ID)
);

 


CREATE TABLE Blogs (
    Blog_id SERIAL PRIMARY KEY,
    Blog_Name VARCHAR(60),
    Category VARCHAR(50),
    Link VARCHAR(255),
    Blog_postedBy INT
);

 


CREATE TABLE Blog_Comment (
    Comment_id SERIAL PRIMARY KEY,
    Blog_id INT REFERENCES Blogs (Blog_id),
    Description TEXT,
    Posted_by INT
);

 


CREATE TABLE fees (
    Doctor_id INT REFERENCES Doctor_profile (Doctor_id),
    Speciality VARCHAR(50),
    Fees INT
);


CREATE TABLE Tests (
    Test_ID SERIAL PRIMARY KEY,
    Test_Name VARCHAR(100),
    Home_Sample BIT,
    Test_Price DECIMAL(10,2),
    Test_Description TEXT
);
 
 

CREATE TABLE Medicine_Category (
    Category_ID SERIAL PRIMARY KEY,
    Category_Name VARCHAR(30),
    Parent_Category_ID INTEGER REFERENCES Medicine_Category (Category_ID),
    Flag BOOLEAN,
    Category_Image_Path VARCHAR(255),
    Health_Condition TEXT
);


CREATE TABLE Medicine (
    Med_ID SERIAL PRIMARY KEY,
    Category_ID INTEGER REFERENCES Medicine_Category (Category_ID),
    Med_Name VARCHAR(100),
    Med_Price DOUBLE PRECISION,
    Med_Image VARCHAR(255),
    Med_Availability BOOLEAN,
    Exp_Date date
);


 

 


CREATE TABLE Cart_Table_Test (
    TCart_no SERIAL PRIMARY KEY,
    Patient_id INT references Patient_profile (Patient_id),
    Test_id int REFERENCES tests (test_id),
    Price DECIMAL
);

 


CREATE TABLE Test_order (
    Order_no SERIAL PRIMARY KEY,
    Amount DECIMAL,
    Patient_id INT REFERENCES Patient_profile (Patient_id),
    Payment_Mode VARCHAR(40) NOT NULL,
    Transaction_id VARCHAR(30),
    Order_from_id VARCHAR(30),
    Ordered_on TIMESTAMP
);

 

CREATE TABLE Test_order_content (
    Sr_no SERIAL PRIMARY KEY,
    Order_no INT REFERENCES Test_order (Order_no),
    Test_id INT,
    Test_Name VARCHAR(40),
    Price DECIMAL,
    Delivery_Track VARCHAR(255),
    Ordered_on TIMESTAMP
);

 

 

CREATE TABLE Cart_Table_pharmacy (
    MCart_no SERIAL PRIMARY KEY,
    Patient_id INT REFERENCES patient_profile (Patient_id),
    item_id int REFERENCES Medicine (Med_id),
    Quantity INT,
    Price DECIMAL
);

 


CREATE TABLE pharmacy_order (
    Order_no SERIAL PRIMARY KEY,
    Amount DECIMAL,
    Patient_id INT REFERENCES Patient_profile (Patient_id),
    Payment_Mode VARCHAR(40) NOT NULL,
    Transaction_id VARCHAR(30),
    Order_from_id VARCHAR(30),
    Ordered_on TIMESTAMP
);

 


CREATE TABLE Pharmacy_order_content (
    Sr_no SERIAL PRIMARY KEY,
    Order_no INT REFERENCES Pharmacy_order (Order_no),
    Item_id INT,
    Item_Name VARCHAR(40),
    Quantity INT,
    Price DECIMAL,
    Delivery_Track VARCHAR(100),
    Ordered_on TIMESTAMP
);
 

 

CREATE TABLE Medical_Record (
    Record_no SERIAL PRIMARY KEY,
    Record_Name VARCHAR(100),
    Patient_id INT REFERENCES patient_profile (Patient_id),
    Record_address VARCHAR(255),
    Uploaded_by INT,
    Uploaded_on DATE
);

 


CREATE TABLE Feedback_toDoctor (
    Feedback_id SERIAL PRIMARY KEY,
    Doctor_id INT REFERENCES Doctor_Profile (Doctor_id),
    Patient_id INT REFERENCES patient_profile (Patient_id),
    Rating INT,
    Diagnosis VARCHAR(50),
    Treatment VARCHAR(50),
    Examination VARCHAR(50),
    Description TEXT,
    Date DATE
);

 


CREATE TABLE Feedback_Hospital (
    Feedback_id SERIAL PRIMARY KEY,
    Centre_id INT,
    Patient_id INT REFERENCES patient_profile (Patient_id),
    QualityOfService VARCHAR(50),
    Waitingtime VARCHAR(50),
    StaffBehavior VARCHAR(50),
    Cleanliness_hygine VARCHAR(50),
    Rating INT,
    Description TEXT,
    Date DATE
);

 


CREATE TABLE Feedback_Lab (
    Feedback_id SERIAL PRIMARY KEY,
    Lab_id INT,
    Patient_id INT REFERENCES patient_profile (Patient_id),
    Rating INT,
    QualityOfService VARCHAR(50),
    Waitingtime VARCHAR(50),
    StaffBehavior VARCHAR(50),
    Cleanliness_hygine VARCHAR(50),
    Descriptions TEXT,
    Date DATE
);

 


CREATE TABLE Likes_Blog (
    Patient_id INT REFERENCES patient_profile (patient_id),
    Blog_id SERIAL,
    PRIMARY KEY (Patient_id, Blog_id),
    FOREIGN KEY (Blog_id) REFERENCES Blogs (Blog_id)
);



 



 

ALTER TABLE Medicine DROP COLUMN Exp_Date;

 

 

 

CREATE TABLE Medicine_Details (
    MD_ID SERIAL PRIMARY KEY,
    Med_ID INTEGER REFERENCES Medicine (Med_ID),
    Highlights VARCHAR(255),
    Description TEXT,
    Indications TEXT,
    Key_Components TEXT,
    Direction_For_Use TEXT,
    Storage TEXT,
    Precautions TEXT
);

 

 

CREATE TABLE Pharmacy (
    Pharma_ID SERIAL PRIMARY KEY,
    Approval_Status BOOLEAN,
    Pharma_Name VARCHAR(50),
    Pharma_City VARCHAR(50),
    Pharma_Address VARCHAR(255),
    Pharma_Official_Email VARCHAR(255),
    Pharma_Official_Contact VARCHAR(10),
    Pharma_Reg_Certi_Path VARCHAR(255),
    Pharma_Reg_Time_Stamp TIMESTAMP
);

 

 CREATE TABLE Hospitals (
    Hospital_ID SERIAL PRIMARY KEY,
    Hospital_Name VARCHAR(30),
    Hospital_City VARCHAR(30),
    Hospital_Address VARCHAR(200),
    H_Open_Time TIME,
    H_Close_Time TIME,
    H_Official_Email VARCHAR(255),
    H_Official_Contact VARCHAR(10),
    H_Reg_Certi_Path VARCHAR(200),
    H_Reg_Time_Stamp TIMESTAMP
);



 

 

CREATE TABLE Inventory (
    inv_ID INT PRIMARY KEY,
    Med_ID INT references Medicine (Med_id),
    Pharma_ID INT references Pharmacy (Pharma_ID),
    Med_units INT,
    exp_date date,
    mfg_date date,
    pack_size varchar(50)
);

 

 

CREATE TABLE Departments (
    Dept_ID SERIAL PRIMARY KEY,
    Hospital_id int references Hospitals (Hospital_id),
    Dept_Name VARCHAR(50),
    Parent_Dept_ID INTEGER,
    Flag BIT,
    Dept_Img_Path VARCHAR(255),
    Dept_Description TEXT
);

 




 




alter table hospitals add column h_gst_no varchar(30); 

create table doc_hospital (
    Doctor_id int references Doctor_profile (Doctor_id),
    Hospital_id int references Hospitals (Hospital_ID)
);

 


CREATE TABLE Labs (
    Lab_ID SERIAL PRIMARY KEY,
    Lab_City VARCHAR(50),
    Lab_Address VARCHAR(255),
    Lab_Name VARCHAR(50),
    Lab_Price INTEGER,
    Lab_Reg_Certi_Path VARCHAR(255),
    Lab_Reg_Time_Stamp TIMESTAMP
);

 


CREATE TABLE Tests_Lab (
    Test_Lab_ID SERIAL PRIMARY KEY,
    Test_ID INTEGER REFERENCES Tests(Test_ID),
    Lab_ID INTEGER REFERENCES Labs(Lab_ID),
    Gov_Lab_Apro_Certi_Path VARCHAR(255),
    OH_Lab_Apro_Status BIT
);

 


CREATE TABLE Video_Conference (
    Vc_ID SERIAL PRIMARY KEY,
    Doctor_ID INTEGER REFERENCES Doctor_profile(Doctor_ID),
    Patient_ID INTEGER REFERENCES Patient_profile(Patient_ID),
    Date TIMESTAMP
);

 


 
CREATE TABLE doc_add (
    doctor_id INTEGER,
    Address TEXT,
    FOREIGN KEY (doctor_id) REFERENCES doctor_profile(doctor_id)
);


create table doctor_hospital_association (
	Doctor_id int references doctor_profile (doctor_id),
	Hospital_id int references hospitals (Hospital_id),
	H_gst_no varchar(30)
);


-- error 
-- alter table departments add column Hospital_id int references hospitals (hospital_id);
alter table patient_doctor_relation add constraint doc_patient_relation_fk foreign key(doctor_id) references doctor_profile(doctor_id);
alter table patient_doctor_relation add constraint doc_patient_relation_fk1 foreign key(patient_id) references patient_profile(patient_id);




CREATE TABLE Lab_Admin (

    LabAdmin_id SERIAL PRIMARY KEY,

    Lab_id INT REFERENCES Labs(Lab_id),

    Name VARCHAR(50) NOT NULL,

    Email_ID VARCHAR(100) NOT NULL,

    Password VARCHAR(100) NOT NULL,

    Contact VARCHAR(15) NOT NULL,

    Added_by INT

);


CREATE TABLE Hospital_Admin (

    HospitalAdmin_id SERIAL PRIMARY KEY,

    Hospital_id INT REFERENCES Hospitals(Hospital_id),

    Name VARCHAR(50) NOT NULL,

    Email_ID VARCHAR(100) NOT NULL,

    Password VARCHAR(100) NOT NULL,

    Contact VARCHAR(15) NOT NULL,

    Added_by INT

);



CREATE TABLE Pharma_Admin (

    PharmaAdmin_id SERIAL PRIMARY KEY,

    Pharma_id INT REFERENCES Pharmacy(Pharma_id),

    Name VARCHAR(50) NOT NULL,

    Email_ID VARCHAR(100) NOT NULL,

    Password VARCHAR(100) NOT NULL,

    Contact VARCHAR(15) NOT NULL,

    Added_by INT

);



CREATE TABLE Hospital_Discount (
    Offer_ID SERIAL PRIMARY KEY,
    Hospital_ID INT REFERENCES Hospitals (Hospital_ID),
    Offer_Name VARCHAR(100),
    Offer_Description TEXT,
    Discount_Percentage DECIMAL(5, 2),
    Start_Date DATE,
    End_Date DATE,
    Criteria TEXT
    );


CREATE TABLE Lab_Discount (
    Offer_ID SERIAL PRIMARY KEY,
    Lab_ID INT REFERENCES Labs (Lab_ID),
    Test_ID INT REFERENCES Tests(Test_ID),
    Offer_Name VARCHAR(100),
    Offer_Description TEXT,
    Discount_Percentage DECIMAL(5, 2),
    Start_Date DATE,
    End_Date DATE
);


CREATE TABLE Medicine_Discount (
    Offer_ID SERIAL PRIMARY KEY,
    Med_ID INT REFERENCES Medicine (Med_ID),
    Offer_Name VARCHAR(100),
    Offer_Description TEXT,
    Discount_Percentage DECIMAL(5, 2),
    Start_Date DATE,
    End_Date DATE
);



CREATE TABLE Hospital_Advertising (
    Ad_ID SERIAL PRIMARY KEY,

    Hospital_ID INT REFERENCES Hospitals (Hospital_ID),

    Ad_Name VARCHAR(100),

    Ad_Type VARCHAR(50) CHECK (Ad_Type IN ('TEXT', 'VIDEO','SPONSORED CONTENT')),

    Ad_Content_Path VARCHAR(50),
    Start_Date DATE,

    End_Date DATE,

    Ad_Description TEXT
    );



CREATE TABLE Lab_Advertising (
    Ad_ID SERIAL PRIMARY KEY,
    Lab_ID INT REFERENCES Labs (Lab_ID),
    Ad_Name VARCHAR(100),
    Ad_Type VARCHAR(50) CHECK (Ad_Type IN ('TEXT', 'VIDEO', 'SPONSORED CONTENT')),
    Ad_Content_Path VARCHAR(50),
    Start_Date DATE,
    End_Date DATE,
    Ad_Description TEXT
);

CREATE TABLE Admin_Notifications (
    Notification_ID SERIAL PRIMARY KEY,
    Super_Admin_ID INT REFERENCES Super_Admin (Admin_id),
    Addressed_To VARCHAR(50),
--    ### ALL,Lab Admin,HospitalAdmin,Pharma_admin ###
    Addressed_To_ID INT,
    Title VARCHAR(100),
    Message TEXT,
    Created_At TIMESTAMP
);




























