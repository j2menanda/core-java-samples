//package com.nanda.java.samples.others;
//
//import javax.microedition.lcdui.*;
//import javax.microedition.midlet.*;
//import javax.microedition.io.*;
//import java.io.*;
//
//public class InsuranceAgent extends MIDlet implements CommandListener
//{
//    List main_menu;
//    Display disp;
//    Command proceed1, exit, login, back, submit, view, send;
//    Form login_screen, new_account;
//    TextField username, password, name, age, salary, budget;
//    Alert msg;
//
//    boolean logged_in = false;
//    InsuranceAgent current_object;
//    String login_name = "";
//
//////////////////////////////////////////////////////////////////////////
//
//    public void startApp(){}
//    public void pauseApp(){}
//    public void destroyApp( boolean b ){}
//
//////////////////////////////////////////////////////////////////////////
//
//    public InsuranceAgent()
//    {
//        main_menu = new List( "Main Menu", Choice.EXCLUSIVE );
//
//        main_menu.append( "Login", null );
//
//        proceed1 =  new Command("Proceed",Command.OK, 0 );
//        exit =  new Command( "exit", Command.EXIT, 1 );
//
//        main_menu.addCommand(proceed1);
//        main_menu.addCommand(exit);
//        main_menu.setCommandListener(this);
//
//        disp = Display.getDisplay( this );
//        disp.setCurrent( main_menu );
//
////----------------------------------------------------------
//
//        login_screen = new Form( "Enter login details" );
//
//        username = new TextField( "Username", "", 15, TextField.ANY );
//        password = new TextField( "Password", "", 10, TextField.PASSWORD );
//
//        login_screen.append( username );
//        login_screen.append( new Spacer( 10, 10 ) );
//        login_screen.append( password );
//
//        login =  new Command( "Login", Command.SCREEN, 1 );
//        back = new Command( "Back", Command.SCREEN, 0 );
//
//        login_screen.addCommand( login );
//        login_screen.addCommand( back );
//        login_screen.addCommand( exit );
//        login_screen.setCommandListener( this );
//
////----------------------------------------------------------
//
//        new_account = new Form( "Enter details for account creation");
//
//        name = new TextField( "Username", "", 15, TextField.ANY );
//        age = new TextField( "Age", "", 15, TextField.NUMERIC );
//        salary = new TextField( "Salary", "", 15, TextField.NUMERIC );
//        budget = new TextField( "Budget", "", 15, TextField.NUMERIC );
//
//        new_account.append( name );
//        new_account.append( new Spacer( 3, 3 ) );
//        new_account.append( age );
//
//        new_account.append( new Spacer( 3, 3 ) );
//        new_account.append( salary );
//        new_account.append( new Spacer( 3, 3 ) );
//        new_account.append( budget );
//        new_account.append( new Spacer( 3, 3 ) );
//
//        send = new Command( "Send", Command.SCREEN, 1 );
//
//        new_account.addCommand( back );
//        new_account.addCommand( exit );
//        new_account.addCommand( send );
//
//
//        new_account.setCommandListener( this );
//
//        current_object = this;
//
//    }
//
//////////////////////////////////////////////////////////////////////////
//
//    public void commandAction( Command com, Displayable d1 )
//    {
//        if( com ==  proceed1 && d1 == main_menu )
//        {
//            disp.setCurrent( login_screen );
//        }
//
//        else if( com == login )
//        {
//            login();
//        }
//        else if( com == submit )
//        {
//            disp.setCurrent(new_account);
//        }
//
//        else if( com == back && d1 == new_account)
//        {
//            disp.setCurrent( main_menu );
//        }
//        else if( com == back && d1 == login_screen )
//        {
//            disp.setCurrent( main_menu );
//        }
//
//        /*else if( com == proceed1 )
//        {
//            disp.setCurrent( new_account );
//        }*/
//
//        else if (com == send )
//        {
//            register();
//        }
//
//        else if( com == exit)
//        {
//            notifyDestroyed();
//        }
//    }
//
////////////////////////////////////////////////
//
//    public void login()
//    {
//        if( (! username.getString().trim().equals("") ) && (! password.getString().trim().equals("" )  )  )
//        {
//            Thread t = new Thread()
//            {
//                public void run()
//                {
//                    try
//                    {
//
//                        HttpConnection hp = (HttpConnection) Connector.open( "http://localhost:8080/servlet/loginservlet?param=" + username.getString().trim() + ":" + password.getString().trim() );
//                        InputStream is = hp.openInputStream();
//                                      int ch;
//                        String message = "";
//                        while( ( ch = is.read() ) != -1 )
//                        message += (char) ch;
//
//                        is.close();
//                        hp.close();
//
//                        if( message.trim().equals( "positive" ) )
//                        {
//                            Alert alert = new Alert( "Message", "Login success ", null, AlertType.INFO );
//                            alert.setTimeout( Alert.FOREVER );
//                            submit =  new Command("Submit",Command.OK, 0 );
//                            alert.addCommand( submit );
//                            alert.setCommandListener( current_object );
//                            disp.setCurrent( alert );
//                        }
//                        else if( message.trim().equals( "negative" ) )
//                        {
//                            Alert alert = new Alert( "Error", "Login failure. Try again!", null, AlertType.INFO );
//                            alert.setTimeout( Alert.FOREVER );
//                            disp.setCurrent( alert );
//                        }
//                        else
//                        {
//                            Alert alert = new Alert( "Error", "No reply from Server. Try again ater!", null, AlertType.INFO );
//                            alert.setTimeout( Alert.FOREVER );
//                            disp.setCurrent( alert );
//                        }
//                    }
//                    catch( Exception e )
//                    {
//                        System.out.println( e );
//                    }
//                    username.setString( "" );
//                    password.setString( "" );
//                }
//            };
//            t.start();
//        }
//        else
//        {
//            Alert alert = new Alert( "Error", " Entries are not complete. ", null, AlertType.INFO );
//            alert.setTimeout( Alert.FOREVER );
//
//            disp.setCurrent( alert );
//        }
//    }
//
////////////////////////////////////////////////
//
//    public void register()
//    {
//        Thread t = new Thread()
//        {
//            public void run()
//            {
//                try
//                {
//
//
//                    HttpConnection hp = (HttpConnection) Connector.open( "http://localhost:8080/servlet/servlet1?param=" + name.getString().trim() + ":" + age.getString().trim()+ "/"  + salary.getString().trim() + "," + budget.getString().trim() );
//
//
//
//                    InputStream is =  hp.openInputStream();
//                    int ch;
//                    String response = "";
//
//                    while( (ch = is.read() )!= -1 )
//                    response +=  (char) ch;
//
//                    Form f = new Form("Details");
//
//                    StringItem pre1= new StringItem( "", response);
//
//                    f.append(pre1);
//
//                    disp.setCurrent( f );
//
//
//                    is.close();
//                    hp.close();
//
//
//
//                }
//                catch( Exception e)
//                {
//                    System.out.println( e );
//                }
//            }
//        };
//        t.start();
//    }
//
//}