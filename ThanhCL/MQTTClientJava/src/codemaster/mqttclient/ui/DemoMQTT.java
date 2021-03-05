package codemaster.mqttclient.ui;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class DemoMQTT {
	private static int roamount = 0;
	private static int fuelamount = 0;
    private static final String USERNAME = "iothome";
    private static final String PASSWORD = "password";

	public static void main(String[] args) {
		int slp = 500;
		String clientId = "subsId";

		String guageMsg = null;
		String pieChartMsg = null;
		String cardMessage = null;
		String barChartMessage = null;
		String chartJSMessage = null;
		String chartDHTMessage = null;

		String topic    = "home01/noticeboard";
		String content  = "Message from MqttPublishSample";

		String topic1   = "home01/demo/guage";
		String topic11   = "home01/demo/guage1";
		String topic21   = "home01/demo/guage2";
		String topic2   = "home01/demo/piechart";
		String topic3   = "home01/demo/currencycard";
		String topic4   = "home01/demo/barchart";
		String topic5   = "home01/demo/chartjs";
		String topic6   = "home01/demo/chartDHT";
		String topic61   = "home01/demo/chartDHT1";
		String topic7   = "home01/demo/light1";
		String topic8   = "home01/demo/aircon1";
		int numOfTopics = 11;

		int qos = 2;
		boolean retained = true;
		String broker = "tcp://mqtt.iothome.vn:1883";
		
		MemoryPersistence persistence = new MemoryPersistence();

		MqttClient mqttClient;
		try {
			mqttClient = new MqttClient(broker, clientId, persistence);
			MqttConnectOptions connOpts = new MqttConnectOptions();
			connOpts.setCleanSession(true);
			connOpts.setUserName(USERNAME);
			connOpts.setPassword(PASSWORD.toCharArray());
			
			System.out.println("Connecting to broker: " + broker);
			mqttClient.connect(connOpts);
			System.out.println("Connected");

			for (;;) {
				// String value = getNextValue();

				int j = (int) (Math.random() * numOfTopics + 1);
				//j=10;
				if (j == 11) {
					guageMsg = getNextValue0To30();
					content = guageMsg;
					topic = topic8;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);

				} else if (j == 10) {
					guageMsg = getSwitchValue();
					content = guageMsg;
					topic = topic7;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);

				} else if (j == 9) {
					guageMsg = formatGuageMessage();
					content = guageMsg;
					topic = topic11;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);

				} else if (j == 8) {
					guageMsg = formatGuageMessage();
					content = guageMsg;
					topic = topic21;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);


				} else if (j == 7) {
					chartDHTMessage = formatDHTMessage();
					content = chartDHTMessage;
					topic = topic61;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);

				} else if (j == 6) {
					chartDHTMessage = formatDHTMessage();
					content = chartDHTMessage;
					topic = topic6;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);

				} else if (j == 5) {
					chartJSMessage = formatChartJSMessage();
					content = chartJSMessage;
					topic = topic5;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);

				} else if (j == 1) {
						guageMsg = formatGuageMessage();
						content = guageMsg;
						topic = topic1;
						MqttMessage message = new MqttMessage(content.getBytes());
						message.setQos(qos);
						message.setRetained(retained);
						mqttClient.publish(topic, message);
						System.out.println("Publishing --> " + topic + "\t: " + content);

				} else if (j == 2) {
					pieChartMsg = formatPieChartMessage();
					content = pieChartMsg;
					topic = topic2;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);
					
				} else if (j == 3) {
					cardMessage = formatCardMessage();
					content = cardMessage;
					topic = topic3;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);
					
				} else if (j == 4) {
					barChartMessage = formatBarChartMessage();
					content = barChartMessage;
					topic = topic4;
					MqttMessage message = new MqttMessage(content.getBytes());
					message.setQos(qos);
					message.setRetained(retained);
					mqttClient.publish(topic, message);
					System.out.println("Publishing --> " + topic + "\t: " + content);
					
				}
				try {
					Thread.sleep(slp);
				} catch (Exception e) {

				}
			}
		} catch (MqttException me) {
			System.out.println("reason " + me.getReasonCode());
			System.out.println("msg " + me.getMessage());
			System.out.println("loc " + me.getLocalizedMessage());
			System.out.println("cause " + me.getCause());
			System.out.println("excep " + me);
			me.printStackTrace();
		}

	}
	
	private static int map(int value, int fromMin, int fromMax, int toMin, int toMax) {
		return (int) (1.0 * value * (toMax - toMin) / (fromMax - fromMin));
	}

	private static String getNextValue() {

		Integer r = new Integer(70 + (int) (Math.random() * 30));
		return r.toString();
	}

	private static String getSwitchValue() {

		Integer r = new Integer(1 - (int) Math.round(Math.random()));
		return (r == 1) ? "true" : "false";
	}

	private static String getNextValue0To30() {

		Integer r = 100 - new Integer(70 + (int) (Math.random() * 30));
		return r.toString();
	}

	private static String formatDHTMessage() {
		String msg = null;
		msg = "[{'value1':" + getNextValue() + ", 'value2':" + getNextValue0To30() + "}]";
		return msg;

	}

	private static String formatChartJSMessage() {
		String msg = null;
		fuelamount -= map(Integer.parseInt(getNextValue()),0,100,0,5);
		if (fuelamount < 0) fuelamount = 100;
		msg = map(Integer.parseInt(getNextValue()),0,100,0,6000) + "|" + 
			  map(Integer.parseInt(getNextValue()),0,100,0,280)  + "|" + 
			  fuelamount + "|0|0";
		return msg;

	}

	private static String formatGuageMessage() {
		String msg = null;
		msg = getNextValue();
		return msg;

	}

	private static String formatSwitchValue() {
		String msg = null;
		msg = getSwitchValue();
		return msg;

	}

	private static String formatPieChartMessage() {
		String msg = null;
		msg = "[['USA', " + getNextValue() + "], ['Europe'," + getNextValue() + "]," + "['Asia', " + getNextValue()
				+ "]]";
		return msg;

	}

	private static String formatBarChartMessage() {
		String msg = null;
		msg = "[{value1:" + getNextValue() + ", value2:" + getNextValue() + ", value3:"
				+ getNextValue() + "}]";
		return msg;

	}

	private static String formatCardMessage() {
		String msg = null;
		roamount += new Integer(getNextValue());
		// msg = getNextValue2();
		msg = new Integer(roamount).toString();
		return msg;

	}

}
