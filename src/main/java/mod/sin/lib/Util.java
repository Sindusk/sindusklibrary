package mod.sin.lib;

import java.util.logging.Logger;

import javassist.CannotCompileException;
import javassist.CtClass;
import javassist.NotFoundException;
import javassist.expr.ExprEditor;
import javassist.expr.MethodCall;

public class Util {
	public static final Logger logger = Logger.getLogger(Util.class.getName());

	private static boolean success = false;
	private static String reason = "";
	public static void setReason(String reason){
		Util.reason = " [Reason: "+reason+"]";
	}
	private static void checkSuccess(int type, Class<?> instrumentingClass, CtClass editClass, String declaredMethod, String methodCall){
		String editType = "Instrument";
		if(type == 1){
			editType = "Insert";
		}else if(type == 2){
			editType = "Set Body";
		}
		String errorType = editType.toUpperCase();
		Logger classLogger = Logger.getLogger(instrumentingClass.getName());
		if(success){
			classLogger.info(editType+": "+editClass.getSimpleName()+" - "+declaredMethod+" "+(methodCall.length() > 0 ? "call to "+methodCall+" " : "")+"successful."+reason);
		}else{
			classLogger.severe("["+errorType+" ERROR] from "+instrumentingClass.getSimpleName()+"! Could not "+editType+" "+editClass.getName()+" - "+declaredMethod+(methodCall.length() > 0 ? " call to "+methodCall+" " : "")+"!"+reason);
		}
		success = false;
		reason = "";
	}
	public static void instrumentDeclared(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String methodCall, String replace){
        try {
			ctToInstrument.getDeclaredMethod(declaredMethod).instrument(new ExprEditor(){
			    public void edit(MethodCall m) throws CannotCompileException {
			        if (m.getMethodName().equals(methodCall)) {
			            m.replace(replace);
			            success = true;
                    }
			    }
			});
			checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
		} catch (CannotCompileException | NotFoundException e) {
			//e.printStackTrace();
			checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
			logger.severe(e.getMessage());
		}
	}
	public static void instrumentDescribed(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, String methodCall, String replace){
        try {
			ctToInstrument.getMethod(declaredMethod, descriptor).instrument(new ExprEditor(){
			    public void edit(MethodCall m) throws CannotCompileException {
			        if (m.getMethodName().equals(methodCall)) {
			            m.replace(replace);
			            success = true;
                    }
			    }
			});
			checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
		} catch (CannotCompileException | NotFoundException e) {
			//e.printStackTrace();
			checkSuccess(0, instrumentingClass, ctToInstrument, declaredMethod, methodCall);
			logger.severe(e.getMessage());
		}
	}
	public static void insertAfterDeclared(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String insert){
		try {
			ctToInstrument.getDeclaredMethod(declaredMethod).insertAfter(insert);
			success = true;
			checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
		} catch (CannotCompileException | NotFoundException e) {
			//e.printStackTrace();
			checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
			logger.severe(e.getMessage());
		}
	}
	public static void insertAfterDescribed(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, String insert){
		try {
			ctToInstrument.getMethod(declaredMethod, descriptor).insertAfter(insert);
			success = true;
			checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
		} catch (CannotCompileException | NotFoundException e) {
			//e.printStackTrace();
			checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
			logger.severe(e.getMessage());
		}
	}
	public static void insertBeforeDeclared(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String insert){
		try {
			ctToInstrument.getDeclaredMethod(declaredMethod).insertBefore(insert);
			success = true;
			checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
		} catch (CannotCompileException | NotFoundException e) {
			//e.printStackTrace();
			checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
			logger.severe(e.getMessage());
		}
	}
	public static void insertBeforeDescribed(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, String insert){
		try {
			ctToInstrument.getMethod(declaredMethod, descriptor).insertBefore(insert);
			success = true;
			checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
		} catch (CannotCompileException | NotFoundException e) {
			//e.printStackTrace();
			checkSuccess(1, instrumentingClass, ctToInstrument, declaredMethod, "");
			logger.severe(e.getMessage());
		}
	}
	public static void setBodyDeclared(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String body){
		try {
			ctToInstrument.getDeclaredMethod(declaredMethod).setBody(body);
			success = true;
			checkSuccess(2, instrumentingClass, ctToInstrument, declaredMethod, "");
		} catch (CannotCompileException | NotFoundException e) {
			//e.printStackTrace();
			checkSuccess(2, instrumentingClass, ctToInstrument, declaredMethod, "");
			logger.severe(e.getMessage());
		}
	}
	public static void setBodyDescribed(Class<?> instrumentingClass, CtClass ctToInstrument, String declaredMethod, String descriptor, String body){
		try {
			ctToInstrument.getMethod(declaredMethod, descriptor).setBody(body);
			success = true;
			checkSuccess(2, instrumentingClass, ctToInstrument, declaredMethod, "");
		} catch (CannotCompileException | NotFoundException e) {
			//e.printStackTrace();
			checkSuccess(2, instrumentingClass, ctToInstrument, declaredMethod, "");
			logger.severe(e.getMessage());
		}
	}
}
