// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license. See the LICENSE file in the project root for full license information.

package com.microsoft.store.partnercenter.profiles;

import com.fasterxml.jackson.core.type.TypeReference;
import com.microsoft.store.partnercenter.BasePartnerComponentString;
import com.microsoft.store.partnercenter.IPartner;
import com.microsoft.store.partnercenter.PartnerService;
import com.microsoft.store.partnercenter.models.partners.BillingProfile;

/**
 * The partner billing profile operations implementation.
 */
public class BillingProfileOperations
	extends BasePartnerComponentString
	implements IBillingProfile
{
	/**
	 * Initializes a new instance of the BillingProfileOperations class.
	 * 
	 * @param rootPartnerOperations The root partner operations instance.
	 */
	public BillingProfileOperations(IPartner rootPartnerOperations)
	{
		super(rootPartnerOperations);
	}

	/**
	 * Retrieves the partner billing profile.
	 * 
	 * @return The partner billing profile.
	 */
	@Override
	public BillingProfile get()
	{
		return this.getPartner().getServiceClient().get(
			this.getPartner(),
			new TypeReference<BillingProfile>(){}, 
			PartnerService.getInstance().getConfiguration().getApis().get("GetPartnerBillingProfile").getPath());
	}

	/**
	 * Updates the partner billing profile.
	 * 
	 * @param updatePayload Payload of the update request.
	 * @return Updated partner billing profile.
	 */
	@Override
	public BillingProfile update(BillingProfile updatePayload)
	{
		return this.getPartner().getServiceClient().put(
			this.getPartner(),
			new TypeReference<BillingProfile>(){}, 
			PartnerService.getInstance().getConfiguration().getApis().get("UpdatePartnerBillingProfile").getPath(),
			updatePayload);
	}
}