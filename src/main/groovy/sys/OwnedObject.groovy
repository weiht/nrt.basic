package sys

class OwnedObject
extends BasicObject
implements Owned {
	String ownerId;
	String ownerGroupId;
	String ownerPermissions;
	String ownerGroupPermissions;
	String otherPermissions;
}
