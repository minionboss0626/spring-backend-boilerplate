package in.clouthink.daas.sbb.message.spiImpl;

import in.clouthink.daas.sbb.account.domain.model.AppUser;
import in.clouthink.daas.sbb.account.exception.AppUserRequiredException;
import in.clouthink.daas.sbb.security.frontend.spring.AppUserDetails;
import in.clouthink.daas.bm.core.MessageReceiver;
import in.clouthink.daas.bm.core.impl.MessageReceiverImpl;
import in.clouthink.daas.bm.domain.model.BusinessMessage;
import in.clouthink.daas.bm.security.SecurityContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


/**
 */
public class SecurityContextImpl implements SecurityContext<AppUser> {

	private static final Log logger = LogFactory.getLog(SecurityContextImpl.class);

	@Override
	public AppUser getPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication != null) {
			Object principal = authentication.getPrincipal();
			if (principal instanceof AppUserDetails) {
				return ((AppUserDetails) principal).getUser();
			}
		}

		logger.warn("Current User is not set, authentication: {}");
		return null;
	}

	@Override
	public boolean isReceiver(BusinessMessage businessMessage, AppUser principal) {
		return businessMessage.getReceiverId().equalsIgnoreCase(principal.getId());
	}

	@Override
	public MessageReceiver asReceiver() {
		AppUser appUser = getPrincipal();
		if (appUser == null) {
			throw new AppUserRequiredException();
		}

		MessageReceiverImpl result = new MessageReceiverImpl();
		result.setId(appUser.getId());
		result.setType("appuser");
		result.setName(appUser.getUsername());
		return result;
	}

}