package de.gs_sys.jar.K9;

/*
    Copyright (C) 2018  Georg Schmidt <gs-develop@gs-sys.de>
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.
    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.
    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/


import java.util.UUID;

public class K9Config {

    // RFC 5322 Official Standard
    private static final String RFC_5322_Official_Standard_REGEX =
            "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-" +
            "\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")" +
            "@" +
            "(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]" +
            "|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08" +
            "\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)])";

    private static final String EMAIL_REGEX =
            "^[a-zA-Z0-9_+&*-]+" +
            "(?:\\.[a-zA-Z0-9_+&*-]+)*" +
            "@" +
            "(?:[a-zA-Z0-9-]+\\.)+" +
            "[a-zA-Z]{2,7}$";


    private static String name = "";

    public static String generate(String name, String listMailAddresses, String bbcMail, String auth_username, String auth_password,
                                 String imap_server, String smtp_server) {
        K9Config.name = name;

        return
                "<?xml version='1.0' encoding='UTF-8' standalone='yes' ?>\n" +
                        "<k9settings version=\"49\" format=\"1\">\n" +
                        "  <global>\n" +
                        "    <value key=\"animations\">true</value>\n" +
                        "    <value key=\"attachmentdefaultpath\">/storage/emulated/0/Download</value>\n" +
                        "    <value key=\"backgroundOperations\">WHEN_CHECKED_AUTO_SYNC</value>\n" +
                        "    <value key=\"changeRegisteredNameColor\">false</value>\n" +
                        "    <value key=\"confirmDelete\">false</value>\n" +
                        "    <value key=\"confirmDeleteStarred\">false</value>\n" +
                        "    <value key=\"confirmSpam\">false</value>\n" +
                        "    <value key=\"confirmMarkAllRead\">true</value>\n" +
                        "    <value key=\"countSearchMessages\">true</value>\n" +
                        "    <value key=\"enableDebugLogging\">false</value>\n" +
                        "    <value key=\"enableSensitiveLogging\">false</value>\n" +
                        "    <value key=\"fontSizeMessageComposeInput\">medium</value>\n" +
                        "    <value key=\"fontSizeMessageViewTime\" />\n" +
                        "    <value key=\"gesturesEnabled\">false</value>\n" +
                        "    <value key=\"hideSpecialAccounts\">false</value>\n" +
                        "    <value key=\"language\">default</value>\n" +
                        "    <value key=\"measureAccounts\">true</value>\n" +
                        "    <value key=\"messageListCheckboxes\">false</value>\n" +
                        "    <value key=\"messageListPreviewLines\">2</value>\n" +
                        "    <value key=\"messageListStars\">true</value>\n" +
                        "    <value key=\"messageViewFixedWidthFont\">false</value>\n" +
                        "    <value key=\"messageViewReturnToList\">false</value>\n" +
                        "    <value key=\"messageViewShowNext\">false</value>\n" +
                        "    <value key=\"quietTimeEnabled\">false</value>\n" +
                        "    <value key=\"quietTimeEnds\">7:00</value>\n" +
                        "    <value key=\"quietTimeStarts\">21:00</value>\n" +
                        "    <value key=\"registeredNameColor\">#00008f</value>\n" +
                        "    <value key=\"showContactName\">false</value>\n" +
                        "    <value key=\"showCorrespondentNames\">true</value>\n" +
                        "    <value key=\"sortTypeEnum\">SORT_DATE</value>\n" +
                        "    <value key=\"sortAscending\">false</value>\n" +
                        "    <value key=\"startIntegratedInbox\">false</value>\n" +
                        "    <value key=\"theme\">light</value>\n" +
                        "    <value key=\"messageViewTheme\">use_global</value>\n" +
                        "    <value key=\"useVolumeKeysForListNavigation\">false</value>\n" +
                        "    <value key=\"useVolumeKeysForNavigation\">false</value>\n" +
                        "    <value key=\"wrapFolderNames\">false</value>\n" +
                        "    <value key=\"notificationHideSubject\">NEVER</value>\n" +
                        "    <value key=\"useBackgroundAsUnreadIndicator\">true</value>\n" +
                        "    <value key=\"threadedView\">true</value>\n" +
                        "    <value key=\"splitViewMode\">NEVER</value>\n" +
                        "    <value key=\"messageComposeTheme\">use_global</value>\n" +
                        "    <value key=\"fixedMessageViewTheme\">true</value>\n" +
                        "    <value key=\"showContactPicture\">true</value>\n" +
                        "    <value key=\"autofitWidth\">true</value>\n" +
                        "    <value key=\"colorizeMissingContactPictures\">true</value>\n" +
                        "    <value key=\"messageViewDeleteActionVisible\">true</value>\n" +
                        "    <value key=\"messageViewArchiveActionVisible\">false</value>\n" +
                        "    <value key=\"messageViewMoveActionVisible\">false</value>\n" +
                        "    <value key=\"messageViewCopyActionVisible\">false</value>\n" +
                        "    <value key=\"messageViewSpamActionVisible\">false</value>\n" +
                        "    <value key=\"fontSizeMessageViewContentPercent\">100</value>\n" +
                        "    <value key=\"hideUserAgent\">false</value>\n" +
                        "    <value key=\"hideTimeZone\">false</value>\n" +
                        "    <value key=\"lockScreenNotificationVisibility\">MESSAGE_COUNT</value>\n" +
                        "    <value key=\"confirmDeleteFromNotification\">true</value>\n" +
                        "    <value key=\"messageListSenderAboveSubject\">false</value>\n" +
                        "    <value key=\"notificationQuickDelete\">NEVER</value>\n" +
                        "    <value key=\"notificationDuringQuietTimeEnabled\">true</value>\n" +
                        "    <value key=\"confirmDiscardMessage\">true</value>\n" +
                        "    <value key=\"pgpInlineDialogCounter\">0</value>\n" +
                        "    <value key=\"pgpSignOnlyDialogCounter\">0</value>\n" +
                        "    <value key=\"openPgpProvider\"></value>\n" +
                        "    <value key=\"openPgpSupportSignOnly\">false</value>\n" +
                        "    <value key=\"hideHostnameWhenConnecting\">false</value>\n" +
                        "  </global>\n" +
                        "  <accounts>\n" +
                        "    <account uuid=\"" + UUID.randomUUID().toString() + "\">\n" +
                        "      <name>GS-SEC</name>\n" +
                        "      <incoming-server type=\"IMAP\">\n" +
                        "        <host>" + imap_server + "</host>\n" +
                        "        <port>993</port>\n" +
                        "        <connection-security>SSL_TLS_REQUIRED</connection-security>\n" +
                        "        <authentication-type>PLAIN</authentication-type>\n" +
                        "        <username>" + auth_username + "</username>\n" +
                        "        <password>" + auth_password + "</password>\n" +
                        "        <extra>\n" +
                        "          <value key=\"autoDetectNamespace\">true</value>\n" +
                        "        </extra>\n" +
                        "      </incoming-server>\n" +
                        "      <outgoing-server type=\"SMTP\">\n" +
                        "        <host>" + smtp_server + "</host>\n" +
                        "        <port>465</port>\n" +
                        "        <connection-security>SSL_TLS_REQUIRED</connection-security>\n" +
                        "        <authentication-type>PLAIN</authentication-type>\n" +
                        "        <username>" + auth_username + "</username>\n" +
                        "        <password>" + auth_password + "</password>\n" +
                        "      </outgoing-server>\n" +
                        "      <settings>\n" +
                        "        <value key=\"allowRemoteSearch\">false</value>\n" +
                        (!bbcMail.isEmpty() ? "        <value key=\"alwaysBcc\">" + bbcMail + "</value>\n" : "") +
                        "        <value key=\"alwaysShowCcBcc\">false</value>\n" +
                        "        <value key=\"archiveFolderName\">Archiv</value>\n" +
                        "        <value key=\"autoExpandFolderName\">INBOX</value>\n" +
                        "        <value key=\"automaticCheckIntervalMinutes\">-1</value>\n" +
                        "        <value key=\"chipColor\">#0099cc</value>\n" +
                        "        <value key=\"defaultQuotedTextShown\">true</value>\n" +
                        "        <value key=\"deletePolicy\">DELETE</value>\n" +
                        "        <value key=\"displayCount\">25</value>\n" +
                        "        <value key=\"draftsFolderName\">Entwürfe</value>\n" +
                        "        <value key=\"expungePolicy\">EXPUNGE_IMMEDIATELY</value>\n" +
                        "        <value key=\"folderDisplayMode\">NOT_SECOND_CLASS</value>\n" +
                        "        <value key=\"folderNotifyNewMailMode\">ALL</value>\n" +
                        "        <value key=\"folderPushMode\">FIRST_CLASS</value>\n" +
                        "        <value key=\"folderSyncMode\">FIRST_CLASS</value>\n" +
                        "        <value key=\"folderTargetMode\">NOT_SECOND_CLASS</value>\n" +
                        "        <value key=\"goToUnreadMessageSearch\">false</value>\n" +
                        "        <value key=\"idleRefreshMinutes\">24</value>\n" +
                        "        <value key=\"inboxFolderName\">INBOX</value>\n" +
                        "        <value key=\"led\">false</value>\n" +
                        "        <value key=\"ledColor\">#0099cc</value>\n" +
                        "        <value key=\"localStorageProvider\">InternalStorage</value>\n" +
                        "        <value key=\"markMessageAsReadOnView\">true</value>\n" +
                        "        <value key=\"maxPushFolders\">10</value>\n" +
                        "        <value key=\"maximumAutoDownloadMessageSize\">32768</value>\n" +
                        "        <value key=\"maximumPolledMessageAge\">-1</value>\n" +
                        "        <value key=\"messageFormat\">TEXT</value>\n" +
                        "        <value key=\"messageFormatAuto\">true</value>\n" +
                        "        <value key=\"messageReadReceipt\">false</value>\n" +
                        "        <value key=\"notifyContactsMailOnly\">false</value>\n" +
                        "        <value key=\"notifyMailCheck\">true</value>\n" +
                        "        <value key=\"notifyNewMail\">true</value>\n" +
                        "        <value key=\"notifySelfNewMail\">true</value>\n" +
                        "        <value key=\"pushPollOnConnect\">true</value>\n" +
                        "        <value key=\"quotePrefix\">&gt;</value>\n" +
                        "        <value key=\"quoteStyle\">PREFIX</value>\n" +
                        "        <value key=\"remoteSearchFullText\">false</value>\n" +
                        "        <value key=\"remoteSearchNumResults\">25</value>\n" +
                        "        <value key=\"replyAfterQuote\">false</value>\n" +
                        "        <value key=\"ring\">true</value>\n" +
                        "        <value key=\"ringtone\">content://settings/system/notification_sound</value>\n" +
                        "        <value key=\"searchableFolders\">ALL</value>\n" +
                        "        <value key=\"sentFolderName\">Gesendet</value>\n" +
                        "        <value key=\"showPicturesEnum\">NEVER</value>\n" +
                        "        <value key=\"signatureBeforeQuotedText\">false</value>\n" +
                        "        <value key=\"sortAscending\">false</value>\n" +
                        "        <value key=\"sortTypeEnum\">SORT_DATE</value>\n" +
                        "        <value key=\"spamFolderName\">Spam</value>\n" +
                        "        <value key=\"stripSignature\">true</value>\n" +
                        "        <value key=\"subscribedFoldersOnly\">false</value>\n" +
                        "        <value key=\"syncRemoteDeletions\">true</value>\n" +
                        "        <value key=\"trashFolderName\">Papierkorb</value>\n" +
                        "        <value key=\"useCompression.MOBILE\">true</value>\n" +
                        "        <value key=\"useCompression.OTHER\">true</value>\n" +
                        "        <value key=\"useCompression.WIFI\">true</value>\n" +
                        "        <value key=\"vibrate\">false</value>\n" +
                        "        <value key=\"vibratePattern\">0</value>\n" +
                        "        <value key=\"vibrateTimes\">5</value>\n" +
                        "      </settings>\n" +
                        "      <identities>\n" +
                        idententiies(listMailAddresses) +
                        "      </identities>\n" +
                        "    </account>\n" +
                        "  </accounts>\n" +
                        "</k9settings>";
    }

    private static String idententiies(String listMailAddresses) {
        StringBuilder sb = new StringBuilder();

        listMailAddresses = listMailAddresses.
                replaceAll(",",";").
                replaceAll("\\|",";").
                replaceAll(":",";").
                replaceAll("\r\n",";").
                replaceAll("\n",";");

        if(listMailAddresses.contains(";")) {
            for(String x : listMailAddresses.split(";")) {
                sb.append(identity(x.trim()));
            }
        }
        else if(listMailAddresses.contains(" ")) {
            for(String x : listMailAddresses.split(" ")) {
                sb.append(identity(x.trim()));
            }
        }
        else
            sb.append(identity(listMailAddresses.trim()));

        return sb.toString();
    }

    private static String identity(String email) {

        if(email.isEmpty())
            return "";

        // RFC 5322 Official Standard
        if(!email.matches(RFC_5322_Official_Standard_REGEX)) {
            System.err.println("RFC_5322: Ignored '" + email + "' !");
            return "";
        }

        if(!email.matches(EMAIL_REGEX)) {
            System.err.println("EMAIL_REGEX: Ignored '" + email + "' !");
            return "";
        }

        return  "        <identity>\n" +
                "          <name>" + K9Config.name + "</name>\n" +
                "          <email>" + email + "</email>\n" +
                "          <description>" + email + "</description>\n" +
                "          <settings>\n" +
                "            <value key=\"signature\"></value>\n" +
                "            <value key=\"signatureUse\">false</value>\n" +
                "          </settings>\n" +
                "        </identity>\n";
    }
}
