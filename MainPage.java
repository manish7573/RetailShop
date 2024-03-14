package RetailShop;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.time.LocalDate;  
import java.time.Period;

class Start
{
	//Customer Details
	String cname;
	long cmnum;
	String caddress;
	String dob;
	int cage;
	String cgender;
	String cemail;
	private String cid;
	private String cpassword;
	
	//choice button
	static int choice;
	
	//front page OR Start page
	public void front()
	{
		
		Customer c=new Customer();
		Admin a=new Admin();
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("************************************************************************************");
		System.out.println("Welcome to Online Shopping Store...");
		System.out.println("1. Admin login.");
		System.out.println("2. Customer login.");
		System.out.println("3. Exit.");
		System.out.println("************************************************************************************");
		System.out.println("Enter the Choice: ");
		
		//Input Integer Exaception
		while(true)
		{
			
			if (sc.hasNextInt()) 
			{
				
	            choice= sc.nextInt();
	            break;
	            
	        } 
			else 
			{
				
	            System.err.println("Enter Valid Input.");
	            System.out.println("Enter the Choice: ");
	            sc.next(); // Discard the invalid input
	            
	        }
		}
		
		//validation for choice
		do 
		{
			
			if(choice==1 || choice==2 || choice==3) 
			{
				
				break;
				
			}
			else
			{
				
				System.err.println("Inavlid Choice.");
				System.out.println("Enter the Correct Choice: ");
				choice=sc.nextInt();
				
			}
		}
		while(!(choice==1) || !(choice==2) || !(choice==3));
		
		//Switch to chose
		switch (choice)
		{
		case 1: a.afront();
		break;
		
		case 2: c.cfront();
		break;
		
		case 3: System.out.println("Thank You For Visiting..."); System.exit(0);
		break;
		}
	}
	
	//Setter & Getter for Customer Id 
	public String getCid() {
		return cid;
	}
	
	public void setCid(String cid) {
		this.cid = cid;
	}
	
	//Setter & Getter for Customer Password
	public String getCpassword() {
		return cpassword;
	}
	
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	
	//Normal constructor for calling 
	Start()
	{
		//
	}
	
	//Parameterized Constructor for Start
	Start(String cname,	long cmnum,	String caddress, String dob, int cage, String cgender, String cemail, String cid, String cpassword)
	{
		
		this.cname=cname;
		this.cmnum=cmnum;
		this.caddress=caddress;
		this.dob=dob;
		this.cage=cage;
		this.cgender=cgender;
		this.cemail=cemail;
		this.cid=cid;
		this.cpassword=cpassword;
		
	}
	
}

//Admin Page
class Admin extends Start
{
	
	//Login Details of Admin
	private static String id="manish123";
	private static String password="Manish@123";
	static String eid;
	static String epassword;
	
	//Admin Sign front page
	public void afront() 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		//page of Choice
		System.out.println("************************************************************************************");
		System.out.println("Admin Login Page...");
		System.out.println("1. Admin login.");
		System.out.println("2. Back to Previous Page");
		System.out.println("3. Exit.");
		System.out.println("************************************************************************************");
		System.out.println("Enter the Choice: ");
		
		//validation of input
		while(true)
		{
			
			if (sc.hasNextInt()) 
			{
				
	            choice= sc.nextInt();
	            break;
	            
	        } 
			else 
			{
				
	            System.err.println("Enter Valid Input.");
	            System.out.println("Enter the Choice: ");
	            sc.next(); // Discard the invalid input
	            
	        }
		}
		
		
		//validation of choice
		do 
		{
			
			if(choice==1 || choice==2 || choice==3) 
			{
				break;
			}
			else
			{
				System.err.println("Inavlid Choice.");
				System.out.println("Enter the Correct Choice: ");
				choice=sc.nextInt();
			}
			
		}
		while(!(choice==1) || !(choice==2) || !(choice==3));
		
		//Switch to chose
		switch(choice)
		{
		
		case 1: adminSignIn();
		break;
		
		case 2: front();
		break;
		
		case 3: System.exit(0);
		break;
		
		}
		
	}
	
	//SignIn Page 
	public void adminSignIn()
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Admin Login...");
		System.out.println("Enter Login Id: ");
		eid=sc.nextLine();
		System.out.println("Enter Password: ");
		epassword=sc.nextLine();
		captcha();
		cpassword(eid,epassword);
		
		System.out.println("1. Log In.");
		System.out.println("2. Cancel.");
		System.out.println("Enter the Choice: ");
		
		//validation of input
		while(true)
		{
			
			if (sc.hasNextInt()) 
			{
				
	            choice= sc.nextInt();
	            break;
	            
	        } 
			else 
			{
				
	            System.err.println("Enter Valid Input.");
	            System.out.println("Enter the Choice: ");
	            sc.next(); // Discard the invalid input
	            
	        }
		}
		
		//validation of choice
		do 
		{
			
			if(choice==1 || choice==2) 
			{
				
				break;
				
			}
			else
			{
				
				System.err.println("Inavlid Choice.");
				System.out.println("Enter the Correct Choice: ");
				choice=sc.nextInt();
				
			}
			
		}
		while(!(choice==1) || !(choice==2));
		
		//Switch to chose
		switch(choice)
		{
		
		case 1: adminSignIn();
		break;
		
		case 2: front();
		break;
		
		
		}
		
	}	
	
	//captcha validation
	public void captcha() 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		Random r=new Random();
		String captcha="";
		
		while(captcha.length()<6)
		{
			
			int n=r.nextInt(122);
			
			if((n>=97 && n<=122) || (n>=48 && n<=57) || (n>=65 && n<=90))
			{
				
				captcha=captcha + (char)n;
				
			}
			
		}
		
		System.out.println("Enter the below captcha: ");
		System.out.println(captcha);
		String usercap=sc.nextLine();
		
		if(usercap.equals(captcha))
		{
			
			System.out.println("Captcha Correct.");
			
		}
		else
		{
			
			System.err.println("Try Again!!");
			captcha();
			
		}
		
	}
	//valdation of id and password
	public void cpassword(String ids,String pass)
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		if(ids.equals(id)) 
		{
			
			if(pass.equals(password))
			{
				
				System.out.println("Login Successful..");
				
			}
			else
			{
				
				System.err.println("Invalid Password");
				System.out.println("Re Enter Password: ");
				epassword=sc.nextLine();
				cpassword(eid, epassword);
				
			}
			
		}
		else
		{
			
			System.err.println("Invalid Id & Password");
			System.out.println("Re Enter Login Id: ");
			eid=sc.nextLine();
			System.out.println("Re Enter Password: ");
			epassword=sc.nextLine();
			cpassword(eid, epassword);
			
		}
		
	}
	
	//Admin Main Page
	public void adminMain() 
	{
		
		System.out.println("yes");
		
	}
	
}

//Customer page
class Customer extends Start
{
	
	static String eid;
	static String epassword;
	
	//Constructor to Store customer details
	Customer(String cname, long cmnum, String caddress,String dob, int cage, String cgender, String cemail, String cid, String cpassword) 
	{
		
		super(cname, cmnum, caddress, dob, cage, cgender, cemail, cid, cpassword);
		
	}

	// Constructor for calling
	Customer() 
	{
		
	}

	public void cfront() 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		//page of Choice
		System.out.println("************************************************************************************");
		System.out.println("Customer Login Page...");
		System.out.println("1. Customer Sign In.");
		System.out.println("2. Customer Sign Up.");
		System.out.println("3. Back to Previous Page");
		System.out.println("4. Exit.");
		System.out.println("************************************************************************************");
		System.out.println("Enter the Choice: ");
		
		//validation for input
		while(true)
		{
			
			if (sc.hasNextInt()) 
			{
				
	            choice= sc.nextInt();
	            break;
	            
	        } 
			else 
			{
				
	            System.err.println("Enter Valid Input.");
	            System.out.println("Enter the Choice: ");
	            sc.next(); // Discard the invalid input
	            
	        }
		}
		
		//validation of choice
		do 
		{
			
			if(choice==1 || choice==2 || choice==3 || choice==4) 
			{
				
				break;
				
			}
			else
			{
				
				System.err.println("Inavlid Choice.");
				System.out.println("Enter the Correct Choice: ");
				choice=sc.nextInt();
				
			}
			
		}
		while(!(choice==1) || !(choice==2) || !(choice==3) || !(choice==4));
		
		switch(choice)
		{
		
		case 1: custSignIn();
		break;
		
		case 2: custSignUp();
		break;
		
		case 3: front();
		break;
		
		case 4: System.exit(0);
		break;
		
		}
		
	}

	//Customer Sign In
	public void custSignIn()
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("************************************************************************************");
		System.out.println("Customer Login...");
		System.out.println("Enter Login Id: ");
		eid=sc.nextLine();
		System.out.println("Enter Password: ");
		epassword=sc.nextLine();
		cpassword(eid,epassword);
		System.out.println("************************************************************************************");
		
	}	
	
	public void cpassword(String ids,String pass)
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		if(ids.equals(getCid())) 
		{
			
			if(pass.equals(getCpassword()))
			{
				
				System.out.println("Login Successful..");
				
			}
			else
			{
				
				System.err.println("Invalid Password");
				System.out.println("Re Enter Password: ");
				epassword=sc.nextLine();
				cpassword(eid, epassword);
				
			}
			
		}
		else
		{
			
			System.err.println("Invalid Id & Password");
			System.out.println("Re Enter Login Id: ");
			eid=sc.nextLine();
			System.out.println("Re Enter Password: ");
			epassword=sc.nextLine();
			cpassword(eid, epassword);
			
		}
		
	}
	
	//Dummy Inputs
	static String cn;
	static long cm;
	static String ca;
	static String db;
	static int ce;
	static String cg;
	static String cem;
	static String cd;
	static String cpass;
	static String confirmpass;
	
	//Customer Sign up
	public void custSignUp() 
	{
		
		//@SuppressWarnings("resource")
		//Scanner sc=new Scanner(System.in);
		Customer c1=new Customer(cn, cm, ca, db, ce, cg, cem, cd, cpass);
		c1.takeDetails();
		
	}
	
	//take Details
	public void takeDetails() 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		System.out.println("Customer New Account Creation..");
		System.out.println("Enter Name: ");
		cname=sc.nextLine();
		
		System.out.println("Enter Mobile Nuber: ");
		
		while(true)
		{
			
			if (sc.hasNextLong()) 
			{
				
	            cmnum= sc.nextLong();
	            break;
	            
	        } 
			else 
			{
				
	            System.err.println("Enter Valid Input.");
	            sc.next(); // Discard the invalid input
	            
	        }
			
		}
		
		this.mobile(cmnum);
		sc.nextLine();
		
		System.out.println("Enter Address: ");
		caddress=sc.nextLine();
		
		System.out.println("Enter DOB in YYYY-MM-DD format: ");
		dob=sc.nextLine();
		
		LocalDate input = LocalDate.parse(dob);
		
		System.out.println("Age: "+calculateAge(input));
		System.out.println();
		
		System.out.println("Select Gender: ");
		System.out.println("1. Male");
		System.out.println("2. Female");
		System.out.println("3. Others");
		
		//validation for input
		while(true)
		{
			
			if (sc.hasNextInt()) 
			{
				
	            choice= sc.nextInt();
	            break;
	            
	        } 
			else 
			{
				
	            System.err.println("Enter Valid Input.");
	            System.out.println("Enter the Choice: ");
	            sc.next(); // Discard the invalid input
	            
	        }
			
		}
		sc.nextLine();
		
		//validation of choice
		do 
		{
			
			if(choice==1 || choice==2 || choice==3) 
			{
				
				break;
				
			}
			else
			{
				
				System.err.println("Inavlid Choice.");
				System.out.println("Enter the Correct Choice: ");
				choice=sc.nextInt();
				sc.nextLine();
				
			}
			
		}
		while(!(choice==1) || !(choice==2) || !(choice==3));
		
		//switch to chose
		switch(choice)
		{
		
		case 1: cgender="Male";
		break;
		
		case 2: cgender="Female";
		break;
		
		case 3: cgender="Others";
		break;
		
		}
		
		System.out.println("Enter Email Id: ");
		cemail=sc.nextLine();
		
		System.out.println("Create Id: ");
		setCid(sc.nextLine());
		
		System.out.println("New Password: ");
		System.err.println("Password must be contains 8-20 characters, contains atleast one digit, contains atleast one Upper case digit,contains atleast lower case digit, contains atleast one special character, don't contain any white spaces..");
		setCpassword(sc.nextLine());
		this.validpass(getCpassword());
		
		System.out.println("Enter Confirm Password: ");
		confirmpass=sc.nextLine();
		this.confirm(confirmpass);
		
		System.out.println("1. Submit.");
		System.out.println("2. Cancel.");
		
		//
		while(true)
		{
			
			if (sc.hasNextInt()) 
			{
				
	            choice= sc.nextInt();
	            break;
	            
	        } 
			else 
			{
				
	            System.err.println("Enter Valid Input.");
	            System.out.println("Enter the Choice: ");
	            sc.next(); // Discard the invalid input
	            
	        }
			
		}
		sc.nextLine();
		
		System.out.println();
		System.out.println("Customer Id: "+getCid());
		System.out.println("Customer Id: "+getCpassword());
		System.out.println();
		
		//validation of choice
		do 
		{
			
			if(choice==1 || choice==2 ) 
			{
				
				break;
				
			}
			else
			{
				
				System.err.println("Inavlid Choice.");
				System.out.println("Enter the Correct Choice: ");
				choice=sc.nextInt();
				
			}
			
		}
		while(!(choice==1) || !(choice==2));
		
		//chose
		switch(choice)
		{
		
		case 1: this.custSignIn();
		break;
		
		case 2: cfront();
		break;
		
		}
		
	}
	
	//Confirm Password Validation
	public void confirm(String pass) 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		if(pass.equals(getCpassword()))
		{
			
			System.out.println("<Password Matched>");
			
		}
		else
		{
			
			System.err.println("Password is not Matching.!");
			System.out.println("Re Enter Password: ");
			confirmpass=sc.nextLine();
			confirm(confirmpass);
			
		}
		
	}
	
	//Password entered validation
	public void validpass(String pass) 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		String regex ="^(?=.*[0-9])" + "(?=.*[A-Z])(?=.*[a-z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,20}$";
		
		Pattern p = Pattern.compile(regex);
		
		if(pass==null)
		{
			
			System.err.println("password is empty!");
			System.out.println("Enter the password: ");
			setCpassword(sc.nextLine());
			validpass(getCpassword());
			
		}
		
		Matcher m=p.matcher(pass);
		
		if(m.matches()==true)
		{

		}
		else
		{
			
			System.err.println("Password is not matching the Credentials.!");
			System.out.println("Re Enter the password: ");
			System.err.println("Password must be contains 8-20 characters, contains atleast one digit, contains atleast one Upper case digit,contains atleast lower case digit, contains atleast one special character, don't contain any white spaces..");
			setCpassword(sc.nextLine());
			validpass(getCpassword());
			
		}
		
	}
	
	//Mobile Number Validator
	public void mobile(long num) 
	{
		
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		
		if(num>999999999l && num<10000000000l)
		{
			//true return
		}
		else
		{
			
			System.err.println("Invalid Mobile Number!");
			System.out.println("Enter Valid Mobile Number: ");
			
			while(true)
			{
				
				if (sc.hasNextLong()) 
				{
					
		            cmnum= sc.nextLong();
		            break;
		            
		        } 
				else 
				{
					
		            System.err.println("Enter Valid Input.");
		            sc.next(); // Discard the invalid input
		            
		        }
				
			}
			
			mobile(cmnum);
			
		}
	}
	
	//DoB to Age converter
	public static int calculateAge(LocalDate dob)   
	{
		LocalDate curDate = LocalDate.now();  
		
		if ((dob != null) && (curDate != null))   
		{  
			return Period.between(dob, curDate).getYears();  
		}  
		else  
		{  
			return 0;  
		} 
	}
}


class MainPage 
{
	static int choice;
	
	public static void main(String[] args)
	{
		
		Start s= new Start();
		s.front();
		
	}
	
}
