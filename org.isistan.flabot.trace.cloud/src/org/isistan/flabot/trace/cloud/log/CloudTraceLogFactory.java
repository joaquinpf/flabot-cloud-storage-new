package org.isistan.flabot.trace.cloud.log;

import org.eclipse.emf.ecore.resource.Resource;
import org.isistan.flabot.trace.log.LogContext;
import org.isistan.flabot.trace.log.LogFactory;
import org.isistan.flabot.trace.log.Tag;
import org.isistan.flabot.trace.log.TraceLog;
import org.isistan.flabot.trace.log.TraceLogFactory;

public class CloudTraceLogFactory implements TraceLogFactory {

	private Resource resource;

	public CloudTraceLogFactory(Resource resource) {
		this.resource = resource;
	}

	public LogContext createLogContext(TraceLog traceLog) {
		return LogFactory.eINSTANCE.createLogContext();
	}

	public Tag createTag(TraceLog traceLog) {
		return LogFactory.eINSTANCE.createTag();
	}

	public TraceLog createTraceLog() {
		TraceLog traceLog = LogFactory.eINSTANCE.createTraceLog();
		resource.getContents().add(traceLog);
		return traceLog;
	}

}
